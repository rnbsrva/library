package com.akerke.demo.service;

import com.akerke.demo.dto.BookDTO;
import com.akerke.demo.dto.BookResponceDTO;

import java.util.List;

public interface BookService {

    List<BookResponceDTO> getAll();
    BookResponceDTO getById(Long id);
    void save (BookDTO bookDTO);
    boolean delete(Long id);
}
