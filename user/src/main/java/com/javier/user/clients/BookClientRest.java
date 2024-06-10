package com.javier.user.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.javier.user.model.BookModel;

@FeignClient( name = "service-book")
public interface BookClientRest {

	@GetMapping("/{id}")
	public ResponseEntity<BookModel> getBook(@PathVariable Integer id);
	
	@PostMapping("")
    public ResponseEntity<BookModel> saveBook(@RequestBody BookModel bookModel);
	
	@PutMapping("/{id}")
    public ResponseEntity<BookModel> updateBook(@RequestBody BookModel bookModel, @PathVariable Integer id);

	@DeleteMapping("/{id}")
    public ResponseEntity<BookModel> deleteBook(@PathVariable Integer id);
	
}
