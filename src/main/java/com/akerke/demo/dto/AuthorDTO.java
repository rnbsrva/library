package com.akerke.demo.dto;

import com.akerke.demo.model.Book;
import java.util.List;

public record AuthorDTO (
     String name,
     String surname,
     List<Book> books
     // FIXME: 8/1/2023 remove list
){}
