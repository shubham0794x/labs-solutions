package com.ironhack.booklookup.bookformatservice.service.impl;

import com.ironhack.booklookup.bookformatservice.controller.dto.BookFormatsDTO;
import com.ironhack.booklookup.bookformatservice.controller.dto.FormatListDTO;
import com.ironhack.booklookup.bookformatservice.model.BookFormat;
import com.ironhack.booklookup.bookformatservice.repository.BookFormatRepository;
import com.ironhack.booklookup.bookformatservice.service.interfaces.IBookFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookFormatService implements IBookFormatService {

    @Autowired
    private BookFormatRepository bookFormatRepository;

    public BookFormatsDTO getFormats(Long isbn) {
        List<String> formats = checkBookFormats(isbn);
        BookFormatsDTO bookFormatsDTO = new BookFormatsDTO();
        bookFormatsDTO.setIsbn(isbn);
        bookFormatsDTO.setFormats(formats);
        return bookFormatsDTO;
    }

    public FormatListDTO storeFormat(Long isbn, FormatListDTO formatList) {
        for (String i : formatList.getFormatList()) {
            BookFormat bookFormat = new BookFormat();
            bookFormat.setIsbn(isbn);
            bookFormat.setFormat(i);
            bookFormatRepository.save(bookFormat);
        }
        FormatListDTO formatListDTO = new FormatListDTO();
        formatListDTO.setFormatList(bookFormatRepository.findFormatsByIsbn(isbn));
        return formatListDTO;
    }

    private List<String> checkBookFormats(Long isbn) {
        List<String> formats = bookFormatRepository.findFormatsByIsbn(isbn);
        if (formats.size() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No formats found for isbn " + isbn + ".");
        }
        return formats;
    }
}
