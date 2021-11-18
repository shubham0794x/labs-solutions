package com.ironhack.booklookup.bookservice.controller.interfaces;

import com.ironhack.booklookup.bookservice.controller.dto.BookDTO;
import com.ironhack.booklookup.bookservice.model.Book;

public interface IBookController {
    BookDTO getBook(Long isbn);

    Book storeBook(BookDTO bookDTO);
}
