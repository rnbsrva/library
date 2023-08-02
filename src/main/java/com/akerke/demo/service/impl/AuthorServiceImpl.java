package com.akerke.demo.service.impl;

import com.akerke.demo.dao.AuthorDAO;
import com.akerke.demo.dao.BookDAO;
import com.akerke.demo.dto.AuthorDTO;
import com.akerke.demo.dto.AuthorResponceDTO;
import com.akerke.demo.model.Author;
import com.akerke.demo.model.Book;
import com.akerke.demo.service.AuthorService;
import com.akerke.demo.wrapper.BookWrapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDAO authorDAO;
    private final BookDAO bookDAO;

    public AuthorServiceImpl(AuthorDAO authorDAO, BookDAO bookDAO) {
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
    }

    @Override
    public List<AuthorResponceDTO> getAll() {
        List<Author> authors = authorDAO.getAll();
        List<AuthorResponceDTO> authorResponce = new ArrayList<>();
        for(Author author : authors) {
            List<BookWrapper> bookWrappers = bookDAO.getAll().stream()
                    .filter(bookWrapper -> Objects.equals(bookWrapper.getAuthorId(), author.getId()))
                    .toList();
            AuthorResponceDTO authorResponceDTO = new AuthorResponceDTO(author.getId(), author.getName(), author.getSurname(), bookWrappers);
            authorResponce.add(authorResponceDTO);
        }
        return authorResponce;
    }

    @Override
    public AuthorResponceDTO getById(Long id) {
        Author author = authorDAO.getById(id);
        List<BookWrapper> bookWrappers = bookDAO.getAll().stream()
                .filter(bookWrapper -> Objects.equals(bookWrapper.getAuthorId(), id))
                .toList();
        return new AuthorResponceDTO(id, author.getName(), author.getSurname(), bookWrappers);
    }

    @Override
    public void save(AuthorDTO authorDTO) {
        authorDAO.save(authorDTO);
    }

    @Override
    public boolean delete(Long id) {
        bookDAO.getAll().stream()
                .filter(bookWrapper -> Objects.equals(bookWrapper.getAuthorId(), id))
                .forEach(bookWrapper -> bookDAO.delete(bookWrapper.getId()));
        return authorDAO.delete(id);
    }
}
