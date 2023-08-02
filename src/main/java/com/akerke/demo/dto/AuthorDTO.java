package com.akerke.demo.dto;

import com.akerke.demo.model.Book;
import java.util.List;

public record AuthorDTO (
        Long id,
     String name,
     String surname
){}
