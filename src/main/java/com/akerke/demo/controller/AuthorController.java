package com.akerke.demo.controller;

import com.akerke.demo.dto.AuthorDTO;
import com.akerke.demo.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {

    private final AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("all")
    ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(authorService.getAll());
    }

    @GetMapping("{id}")
    ResponseEntity<?> getById(
            @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(authorService.getById(id));
    }

    @PostMapping("new")
    ResponseEntity<?> save(
            @RequestBody AuthorDTO authorDTO
    ) {
        authorService.save(authorDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("created");
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> delete(
            @PathVariable Long id
    ) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(authorService.delete(id));
    }


}
