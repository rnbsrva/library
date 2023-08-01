package com.akerke.demo.service;

import com.akerke.demo.dto.BookDTO;
import com.akerke.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    List<Book> getAll();
    Book getById(Long id);
    void save (BookDTO bookDTO);
    boolean delete(Long id);
}
