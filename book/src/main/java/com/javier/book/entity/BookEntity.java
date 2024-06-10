package com.javier.book.entity;

import com.javier.book.constraint.ISBNValidation;
import com.javier.book.constraint.LengthValidation;
import com.javier.book.constraint.NotBlankValidation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    @Getter @Setter
    private Integer idBook;

    @Getter @Setter
    @NotBlankValidation(message = "Title is required")
    @LengthValidation(message = "Title must be longer than 4 characters")
    private String title;

    @Getter @Setter
    @NotBlankValidation(message = "Author is required")
    @LengthValidation(message = "Author must be longer than 4 characters")
    private String author;

    @Getter @Setter
    @NotBlankValidation(message = "ISBN is required")
    @ISBNValidation(message = "ISBN is invalid")
    private String isbn;
    
    @Transient
    @Getter @Setter
    private Integer port;

}
