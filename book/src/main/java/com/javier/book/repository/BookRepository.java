package com.javier.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javier.book.entity.BookEntity;

@Repository("bookRepository")
public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    public int deleteByIdBook(Integer idBook);

}
