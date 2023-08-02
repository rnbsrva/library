package com.akerke.demo.mapper;

import com.akerke.demo.model.Author;
import com.akerke.demo.model.Book;
import com.akerke.demo.wrapper.BookWrapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<BookWrapper> {

    @Override
    public BookWrapper mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BookWrapper(
                rs.getLong("book_id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getLong("author_id")
        );
    }
}
