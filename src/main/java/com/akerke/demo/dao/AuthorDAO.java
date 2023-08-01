package com.akerke.demo.dao;

import com.akerke.demo.dto.AuthorDTO;
import com.akerke.demo.mapper.AuthorMapper;
import com.akerke.demo.model.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class AuthorDAO {

    private final JdbcTemplate jdbcTemplate;

    public AuthorDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Author> getAll (){
        return jdbcTemplate.query("SELECT * FROM author", new AuthorMapper());
    }

    public Author getById(Long id) {

        return jdbcTemplate.query("SELECT * FROM author WHERE author_id="+id, new AuthorMapper())
                .stream()
                .findAny()
                .orElse(null);
    }

    public void save (AuthorDTO authorDTO){
        jdbcTemplate.update("INSERT INTO author(name, surname) VALUES (?, ?)", authorDTO.name(), authorDTO.surname());
    }

    public boolean delete(Long id) {
        if(getById(id)==null) {
            return false;
        }

        jdbcTemplate.update("DELETE FROM author WHERE author_id="+id);
        return true;
    }


}
