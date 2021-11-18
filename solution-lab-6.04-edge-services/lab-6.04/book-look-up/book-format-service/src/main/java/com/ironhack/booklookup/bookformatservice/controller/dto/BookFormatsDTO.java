package com.ironhack.booklookup.bookformatservice.controller.dto;

import java.util.List;

public class BookFormatsDTO {
    private Long isbn;
    private List<String> formats;

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public List<String> getFormats() {
        return formats;
    }

    public void setFormats(List<String> formats) {
        this.formats = formats;
    }
}
