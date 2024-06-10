package com.javier.user.controller;

import com.javier.user.model.BookModel;
import com.javier.user.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    @Qualifier("userServiceImpl")
    private BookService bookService;

    @GetMapping("/{id}")
    private ResponseEntity<BookModel> getBook(@PathVariable  Integer id) {
        return bookService.getBook(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<BookModel> saveBook(@RequestBody BookModel bookModel) {
        return bookService.saveBook(bookModel);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<BookModel> updateBook(@RequestBody BookModel bookModel, @PathVariable Integer id) {
        return bookService.updateBook(bookModel, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<BookModel> deleteBook(@PathVariable Integer id) {
        return bookService.deleteBook(id);
    }

}
