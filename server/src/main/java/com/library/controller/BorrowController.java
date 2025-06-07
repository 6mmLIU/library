package com.library.controller;

import com.library.entity.BorrowRecord;
import com.library.service.BorrowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST endpoints for borrow and return actions.
 */
@RestController
@RequestMapping("/borrows")
public class BorrowController {
    private final BorrowService service;

    public BorrowController(BorrowService service) {
        this.service = service;
    }

    @PostMapping
    public BorrowRecord borrow(@RequestBody BorrowRecord record) {
        return service.borrowBook(record);
    }

    @PostMapping("/{id}/return")
    public void returnBook(@PathVariable Long id) {
        service.returnBook(id);
    }

    @GetMapping
    public List<BorrowRecord> list() {
        return service.currentBorrows();
    }
}
