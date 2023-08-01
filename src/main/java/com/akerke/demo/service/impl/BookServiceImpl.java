package com.akerke.demo.service.impl;

import com.akerke.demo.dao.BookDAO;
import com.akerke.demo.dto.BookDTO;
import com.akerke.demo.model.Book;
import com.akerke.demo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;


    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<Book> getAll() {
        return bookDAO.getAll();
    }

    @Override
    public Book getById(Long id) {
        return bookDAO.getById(id);
    }

    @Override
    public void save(BookDTO bookDTO) {
        bookDAO.save(bookDTO);
    }

    @Override
    public boolean delete(Long id) {
        return bookDAO.delete(id);
    }
}
