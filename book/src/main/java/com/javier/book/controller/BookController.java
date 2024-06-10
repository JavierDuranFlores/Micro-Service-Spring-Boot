package com.javier.book.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.javier.book.entity.BookEntity;
import com.javier.book.exception.BadRequestException;
import com.javier.book.exception.NoFoundException;
import com.javier.book.exception.UnprocessableException;
import com.javier.book.service.impl.BookServiceImpl;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private Environment env;

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookServiceImpl bookServiceImpl;

    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> getBook(@PathVariable Integer id) {
        BookEntity bookEntity = bookServiceImpl.getIdBook(id).orElseThrow(() -> new NoFoundException("P-404", "book not found"));
        bookEntity.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        return new ResponseEntity<>(bookEntity, HttpStatus.OK);
    }

    @PostMapping(path = "", produces = {"application/json"})
    public ResponseEntity<BookEntity> saveBook(@Valid @RequestBody BookEntity bookEntity, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new BadRequestException("P-400", bindingResult.getFieldError().getDefaultMessage().toString());
        }
        bookEntity.setPort(Integer.parseInt(env.getProperty("local.server.port")));
        BookEntity book = bookServiceImpl.saveBook(bookEntity).orElseThrow(()->new UnprocessableException("P-402", "book not saved"));

        return new ResponseEntity<>(bookEntity, HttpStatus.CREATED);

    }

    @PutMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity<BookEntity> updateBook(@Valid @RequestBody BookEntity bookEntity, @PathVariable Integer id, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new NoFoundException("P-404",bindingResult.getFieldError().getDefaultMessage().toString());
        }
        
        BookEntity book = bookServiceImpl.updateBook(bookEntity, id)
                .orElseThrow(()->new NoFoundException("P-404", "book with id not found"));

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity<BookEntity> deleteBook(@PathVariable Integer id) {
        return bookServiceImpl.getIdBook(id)
                .map(book -> {
                    if (bookServiceImpl.deleteBook(id)) {
                        return new ResponseEntity<>(book, HttpStatus.OK);
                    } else {
                        throw new NoFoundException("P-404", "Book with id not found for deletion");
                    }
                })
                .orElseThrow(() -> new NoFoundException("P-404", "Book with id not found"));
    }

}
