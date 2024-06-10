package com.javier.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.javier.book.entity.BookEntity;
import com.javier.book.repository.BookRepository;
import com.javier.book.service.BookService;

import jakarta.transaction.Transactional;

import java.util.Optional;

@Service("bookServiceImpl")
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    @Qualifier("bookRepository")
    private BookRepository bookRepository;

    @Override
    public Optional<BookEntity> getIdBook(Integer idBook) {
        return bookRepository.findById(idBook);
    }

    @Override
    public Optional<BookEntity> saveBook(BookEntity book) {
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<BookEntity> updateBook(BookEntity book, Integer idBook) {

        // Retrieve the book by its ID
        Optional<BookEntity> existingBookOpt = bookRepository.findById(idBook);

        // Check if the book exists
        if (existingBookOpt.isEmpty()) {
            return Optional.empty();
        }

        BookEntity existingBook = existingBookOpt.get();

        // Update the existing book with new details
        existingBook.setIdBook(idBook);
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setIsbn(book.getIsbn());

        // Return the updated book entity wrapped in an Optional
        return Optional.of(bookRepository.save(existingBook));
    }

    @Override
    public Boolean deleteBook(Integer idBook) {
        return getIdBook(idBook).map(bookEntity -> {
            bookRepository.deleteByIdBook(idBook);
            return true;
        }).orElse(false);
    }
}
