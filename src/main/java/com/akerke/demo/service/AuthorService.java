package com.akerke.demo.service;

import com.akerke.demo.dto.AuthorDTO;
import com.akerke.demo.model.Author;

import java.util.List;

public interface  AuthorService {

    List<Author> getAll();
    Author getById(Long id);
    void save (AuthorDTO bookDTO);
    boolean delete(Long id);

}
