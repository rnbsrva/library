package com.akerke.demo.service;

import com.akerke.demo.dto.AuthorRequestDTO;
import com.akerke.demo.dto.BookDTO;
import com.akerke.demo.dto.BookResponceDTO;

import java.util.List;
import java.util.Map;

public interface BookService {

    List<BookResponceDTO> getAll();
    BookResponceDTO getById(Long id);
    void save (BookDTO bookDTO);
    boolean delete(Long id);

    boolean update(Long id, BookDTO bookDTO);

    boolean updatePartially(Long id, Map<String, Object> bookUpdatedFields);
}
