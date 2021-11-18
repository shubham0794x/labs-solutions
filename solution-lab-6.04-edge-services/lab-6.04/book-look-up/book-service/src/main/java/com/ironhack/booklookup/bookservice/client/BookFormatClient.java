package com.ironhack.booklookup.bookservice.client;

import com.ironhack.booklookup.bookservice.controller.dto.BookFormatsDTO;
import com.ironhack.booklookup.bookservice.controller.dto.FormatListDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("book-format-service")
public interface BookFormatClient {
    @GetMapping("/book-formats/{isbn}")
    BookFormatsDTO getFormats(@PathVariable Long isbn);

    @PostMapping("/book-formats/{isbn}")
    void storeFormat(@PathVariable Long isbn, @RequestBody FormatListDTO formatList);
}
