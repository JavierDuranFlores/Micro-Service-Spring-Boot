package com.javier.user.service;

import org.springframework.http.ResponseEntity;

import com.javier.user.model.BookModel;

public interface BookService {

    public ResponseEntity<BookModel> getBook(Integer idBook);

    public ResponseEntity<BookModel> saveBook(BookModel bookModel);

    public ResponseEntity<BookModel> updateBook(BookModel bookModel, Integer idBook);

    public ResponseEntity<BookModel> deleteBook(Integer idBook);

}
