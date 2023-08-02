package com.akerke.demo.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BookWrapper {
    private Long id;
    private String name;
    private String description;
    private Long authorId;

    public BookWrapper(Long id, String name, String description, Long authorId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.authorId = authorId;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
