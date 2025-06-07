package com.library.controller;

import com.library.entity.BookCopy;
import com.library.service.BookCopyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST endpoints for book copies.
 */
@RestController
@RequestMapping("/copies")
public class BookCopyController {
    private final BookCopyService service;

    public BookCopyController(BookCopyService service) {
        this.service = service;
    }

    @PostMapping
    public BookCopy create(@RequestBody BookCopy copy) {
        return service.addCopy(copy);
    }

    @GetMapping
    public List<BookCopy> list() {
        return service.listCopies();
    }
}
