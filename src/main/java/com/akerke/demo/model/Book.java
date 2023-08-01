package com.akerke.demo.model;

public class Book {

    private Long id;
    private String name;
    private String description;
    private Long author;

    // FIXME: 8/1/2023 change authorId to Author, not dto

    public Book(Long id, String name, String description, Long authorId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.author =authorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }
}
