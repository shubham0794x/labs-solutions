package com.ironhack.booklookup.bookservice.controller.impl;

import com.ironhack.booklookup.bookservice.controller.dto.BookDTO;
import com.ironhack.booklookup.bookservice.controller.interfaces.IBookController;
import com.ironhack.booklookup.bookservice.model.Book;
import com.ironhack.booklookup.bookservice.service.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController implements IBookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/books/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO getBook(@PathVariable Long isbn) {
        return bookService.getBook(isbn);
    }

    @PostMapping("/books")
    public Book storeBook(@RequestBody BookDTO bookDTO) {
        return bookService.storeBook(bookDTO);
    }
}
