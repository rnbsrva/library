package com.akerke.demo.dao;

import com.akerke.demo.dto.AuthorDTO;
import com.akerke.demo.dto.BookDTO;
import com.akerke.demo.mapper.BookMapper;
import com.akerke.demo.model.Book;
import com.akerke.demo.wrapper.BookWrapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BookWrapper> getAll(){
        final String query = "SELECT * FROM book";
        return jdbcTemplate.query(query, new BookMapper());
    }

    public BookWrapper getById(Long id) {
        final String query = "SELECT * FROM book WHERE book_id="+id;
        return jdbcTemplate.query(query, new BookMapper()).get(0);
    }

    public void save(BookDTO bookDTO) {
        jdbcTemplate.update( "INSERT INTO book (name, description, author_id) VALUES (?,?,?);",
                bookDTO.name(), bookDTO.description(), bookDTO.authorId());
    }

    public boolean delete (Long id) {
        BookWrapper book = getById(id);
        if(book==null) {
            return false;
        }
        jdbcTemplate.update("DELETE FROM book WHERE book_id="+id);
        return true;
    }

    public boolean update (BookDTO bookDTO, Long id) {
        if(getById(id)==null) {
            return false;
        }
        jdbcTemplate.update("UPDATE book SET name = ?, description = ?, author_id = ? WHERE book_id = ?", bookDTO.name(), bookDTO.description(), bookDTO.authorId(), id);
        return true;
    }

}
