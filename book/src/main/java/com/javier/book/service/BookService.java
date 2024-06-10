package com.javier.book.service;

import java.util.Optional;

import com.javier.book.entity.BookEntity;

public interface BookService {

    public Optional<BookEntity> getIdBook(Integer idBook);

    public Optional<BookEntity> saveBook(BookEntity book);

    public Optional<BookEntity> updateBook(BookEntity book, Integer idBook);

    public Boolean deleteBook(Integer idBook);

}
