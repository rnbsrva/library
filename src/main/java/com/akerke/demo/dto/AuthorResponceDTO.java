package com.akerke.demo.dto;


import com.akerke.demo.wrapper.BookWrapper;

import java.util.List;

public record AuthorResponceDTO(
         Long id,
         String name,
         String surname,
         List<BookWrapper> books
) {
}
