package com.akerke.demo.service;

import com.akerke.demo.dto.AuthorDTO;
import com.akerke.demo.dto.AuthorResponceDTO;

import java.util.List;

public interface  AuthorService {

    List<AuthorResponceDTO> getAll();
    AuthorResponceDTO getById(Long id);
    void save (AuthorDTO bookDTO);
    boolean delete(Long id);

}
