package com.ironhack.booklookup.bookformatservice.controller.impl;

import com.ironhack.booklookup.bookformatservice.controller.dto.BookFormatsDTO;
import com.ironhack.booklookup.bookformatservice.controller.dto.FormatListDTO;
import com.ironhack.booklookup.bookformatservice.controller.interfaces.IBookFormatController;
import com.ironhack.booklookup.bookformatservice.service.interfaces.IBookFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookFormatController implements IBookFormatController {

    @Autowired
    private IBookFormatService bookFormatService;

    @GetMapping("/book-formats/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public BookFormatsDTO getFormats(@PathVariable Long isbn) {
        return bookFormatService.getFormats(isbn);
    }

    @PostMapping("/book-formats/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public FormatListDTO storeFormat(@PathVariable Long isbn, @RequestBody FormatListDTO formatList) {
        return bookFormatService.storeFormat(isbn, formatList);
    }
}
