package com.akerke.demo.mapper;

import com.akerke.demo.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book (
                rs.getLong("book_id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getLong("author_id")
        );
    }
}
