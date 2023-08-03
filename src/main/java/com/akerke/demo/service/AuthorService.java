package com.akerke.demo.service;

import com.akerke.demo.dto.AuthorDTO;
import com.akerke.demo.dto.AuthorRequestDTO;
import com.akerke.demo.dto.AuthorResponceDTO;

import java.util.List;
import java.util.Map;

public interface  AuthorService {

    List<AuthorResponceDTO> getAll();
    AuthorResponceDTO getById(Long id);
    void save (AuthorDTO authorDTO);
    boolean delete(Long id);

    boolean update(Long id, AuthorRequestDTO authorRequestDTO);

    boolean updatePartially(Long id, Map<String, Object> authorUpdatedFields);

}
