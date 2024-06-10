package com.javier.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class BookModel {

    @Getter  @Setter
    private Integer idBook;

    @Getter @Setter
    private String title;

    @Getter @Setter
    private String author;

    @Getter @Setter
    private String isbn;

    @Getter @Setter
    private Integer port;

}
