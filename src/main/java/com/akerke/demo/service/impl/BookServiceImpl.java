package com.akerke.demo.service.impl;

import com.akerke.demo.dao.AuthorDAO;
import com.akerke.demo.dao.BookDAO;
import com.akerke.demo.dto.AuthorDTO;
import com.akerke.demo.dto.AuthorRequestDTO;
import com.akerke.demo.dto.BookDTO;
import com.akerke.demo.dto.BookResponceDTO;
import com.akerke.demo.model.Author;
import com.akerke.demo.model.Book;
import com.akerke.demo.service.BookService;
import com.akerke.demo.wrapper.BookWrapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;
    private final AuthorDAO authorDAO;


    public BookServiceImpl(BookDAO bookDAO, AuthorDAO authorDAO) {
        this.bookDAO = bookDAO;
        this.authorDAO = authorDAO;
    }

    @Override
    public List<BookResponceDTO> getAll() {
        List<BookWrapper> bookWrappers = bookDAO.getAll();
        List<BookResponceDTO> books = new ArrayList<>();
        for(BookWrapper bookWrapper: bookWrappers){
            Author author = authorDAO.getById(bookWrapper.getAuthorId());
            AuthorDTO authorDTO = new AuthorDTO(author.getId(), author.getName(), author.getSurname());
            books.add(new BookResponceDTO(bookWrapper.getId(), bookWrapper.getName(), bookWrapper.getDescription(), authorDTO));
        }
        return books;
    }

    @Override
    public BookResponceDTO getById(Long id) {
        BookWrapper bookWrapper = bookDAO.getById(id);
        Author author =  authorDAO.getById(bookWrapper.getAuthorId());
        AuthorDTO authorDTO =  new AuthorDTO(author.getId(), author.getName(), author.getSurname());
        return new BookResponceDTO(bookWrapper.getId(), bookWrapper.getName(), bookWrapper.getDescription(), authorDTO);
    }

    @Override
    public void save(BookDTO bookDTO) {
        bookDAO.save(bookDTO);
    }

    @Override
    public boolean delete(Long id) {
        return bookDAO.delete(id);
    }

    @Override
    public boolean update(Long id, BookDTO bookDTO) {
        return bookDAO.update(bookDTO, id);
    }

    @Override
    public boolean updatePartially(Long id, Map<String, Object> bookUpdatedFields) {
        BookWrapper bookWrapper = bookDAO.getById(id);
        String name = bookWrapper.getName();
        String description = bookWrapper.getDescription();
        Long authorId = bookWrapper.getAuthorId();
        for (Map.Entry<String, Object> entry : bookUpdatedFields.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();
            switch (field) {
                case "name" -> name = (String)value;
                case "description" -> description = (String) value;
                case "authorId" -> authorId = (Long) value;
            }
        }
        BookDTO bookDTO = new BookDTO(name, description, authorId);
        return bookDAO.update(bookDTO, id);
    }
}
