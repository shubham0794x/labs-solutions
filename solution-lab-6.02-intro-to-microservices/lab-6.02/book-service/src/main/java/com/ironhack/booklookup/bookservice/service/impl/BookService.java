package com.ironhack.booklookup.bookservice.service.impl;

import com.ironhack.booklookup.bookservice.controller.dto.BookDTO;
import com.ironhack.booklookup.bookservice.controller.dto.BookFormatsDTO;
import com.ironhack.booklookup.bookservice.controller.dto.FormatListDTO;
import com.ironhack.booklookup.bookservice.model.Book;
import com.ironhack.booklookup.bookservice.repository.BookRepository;
import com.ironhack.booklookup.bookservice.service.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private DiscoveryClient discoveryClient;

    public BookDTO getBook(Long isbn) {
        Book book = checkBook(isbn);
        BookFormatsDTO formats = getFormats(isbn);
        BookDTO bookDTO = new BookDTO();
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setGenre(book.getGenre());
        bookDTO.setFormats(formats.getFormats());
        return bookDTO;
    }


    public Book storeBook(BookDTO bookDTO) {
        checkIfBookExists(bookDTO.getIsbn());
        Book book = new Book(bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getGenre());
        book = bookRepository.save(book);
        FormatListDTO formatListDTO = addBookFormats(bookDTO.getIsbn(), bookDTO.getFormats());
        return book;
    }

    private FormatListDTO addBookFormats(Long isbn, List<String> formats) {
        RestTemplate restTemplate = new RestTemplate();
        String url = discoveryClient.getInstances("book-format-service").get(0).getUri().toString();
        FormatListDTO formatListDTO = new FormatListDTO();
        formatListDTO.setFormatList(formats);
        return restTemplate.postForObject(url + "/book-formats/" + isbn, formatListDTO, FormatListDTO.class);
    }

    private BookFormatsDTO getFormats(Long isbn) {
        RestTemplate restTemplate = new RestTemplate();
        String url = discoveryClient.getInstances("book-format-service").get(0).getUri().toString();
        return restTemplate.getForObject(url + "/book-formats/" + isbn, BookFormatsDTO.class);
    }

    private Book checkBook(Long isbn) {
        Optional<Book> book = bookRepository.findById(isbn);
        if (book.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book with isbn " + isbn + " not found.");
        }
        return book.get();
    }

    private void checkIfBookExists(Long isbn) {
        Optional<Book> book = bookRepository.findById(isbn);
        if (book.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book with isbn " + isbn + " already in the database.");
        }
    }
}
