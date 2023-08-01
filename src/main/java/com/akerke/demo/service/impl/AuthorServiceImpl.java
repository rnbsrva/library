package com.akerke.demo.service.impl;

import com.akerke.demo.dao.AuthorDAO;
import com.akerke.demo.dao.BookDAO;
import com.akerke.demo.dto.AuthorDTO;
import com.akerke.demo.model.Author;
import com.akerke.demo.model.Book;
import com.akerke.demo.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDAO authorDAO;
    private final BookDAO bookDAO;

    public AuthorServiceImpl(AuthorDAO authorDAO, BookDAO bookDAO) {
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
    }

    @Override
    public List<Author> getAll() {
        List<Author> authors = authorDAO.getAll();

        for(Author author : authors) {
            List<Book> books = bookDAO.getAll().stream()
                    .filter(book -> Objects.equals(book.getAuthor(), author.getId()))
                    .collect(Collectors.toList());
            author.setBooks(books);
        }

        return authors;
    }

    @Override
    public Author getById(Long id) {
        Author author = authorDAO.getById(id);
        List<Book> books = bookDAO.getAll().stream()
                .filter(book -> Objects.equals(book.getAuthor(), author.getId()))
                .collect(Collectors.toList());
        author.setBooks(books);
        return author;
    }

    @Override
    public void save(AuthorDTO authorDTO) {
        authorDAO.save(authorDTO);
    }

    @Override
    public boolean delete(Long id) {
        Author author= authorDAO.getById(id);
        List<Book> books = bookDAO.getAll().stream()
                .filter(book -> Objects.equals(book.getAuthor(), author.getId()))
                .collect(Collectors.toList());
        author.setBooks(books);
        for (Book book : author.getBooks()) {
            bookDAO.delete(book.getId());
        }
        return authorDAO.delete(id);
    }
}
