package com.akerke.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BookResponceDTO(
        Long id,
        String name,
        String description,
        @JsonProperty("author")
        AuthorDTO authorDTO
) {
}
