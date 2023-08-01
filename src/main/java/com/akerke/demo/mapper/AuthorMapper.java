package com.akerke.demo.mapper;

import com.akerke.demo.model.Author;
import com.akerke.demo.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        List<Book> books = new ArrayList<>();
        return new Author(
                rs.getLong("author_id"),
                rs.getString("name"),
                rs.getString("surname"),
                books
        );
    }
}
