package com.ironhack.booklookup.bookformatservice.service.interfaces;

import com.ironhack.booklookup.bookformatservice.controller.dto.BookFormatsDTO;
import com.ironhack.booklookup.bookformatservice.controller.dto.FormatListDTO;

public interface IBookFormatService {
    BookFormatsDTO getFormats(Long isbn);

    FormatListDTO storeFormat(Long isbn, FormatListDTO formatList);
}
