package com.library.controller;

import com.library.entity.Book;
import com.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST endpoints for books.
 */
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return service.addBook(book);
    }

    @GetMapping
    public List<Book> list() {
        return service.listBooks();
    }
}
