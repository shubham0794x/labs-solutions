package com.ironhack.booklookup.bookservice.service.interfaces;

import com.ironhack.booklookup.bookservice.controller.dto.BookDTO;
import com.ironhack.booklookup.bookservice.model.Book;

public interface IBookService {
    BookDTO getBook(Long isbn);

    Book storeBook(BookDTO bookDTO);
}
