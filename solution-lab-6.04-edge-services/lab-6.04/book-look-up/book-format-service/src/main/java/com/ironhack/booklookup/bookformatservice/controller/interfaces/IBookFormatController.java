package com.ironhack.booklookup.bookformatservice.controller.interfaces;

import com.ironhack.booklookup.bookformatservice.controller.dto.BookFormatsDTO;
import com.ironhack.booklookup.bookformatservice.controller.dto.FormatListDTO;

public interface IBookFormatController {
    BookFormatsDTO getFormats(Long isbn);

    FormatListDTO storeFormat(Long isbn, FormatListDTO formatList);
}
