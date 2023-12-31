package com.akerke.demo.controller;

import com.akerke.demo.dto.AuthorRequestDTO;
import com.akerke.demo.dto.BookDTO;
import com.akerke.demo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("book")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("all")
    ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK).
                body(bookService.getAll());
    }

    @GetMapping("{id}")
    ResponseEntity<?> getById(
            @PathVariable Long id
    ) {
        return ResponseEntity.status(HttpStatus.OK).
                body(bookService.getById(id));
    }

    @PostMapping("new")
    ResponseEntity<?> save(
            @RequestBody BookDTO bookDTO
    ) {
        bookService.save(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("created");
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> delete(
            @PathVariable Long id
    ) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).
                body(bookService.delete(id));
    }


    @PutMapping("{id}")
    ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestBody BookDTO bookDTO
    ){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(bookService.update(id, bookDTO));
    }

    @PatchMapping("{id}")
    ResponseEntity<?> updatePartially(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updatedFields
    ) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(bookService.updatePartially(id, updatedFields));
    }


}
