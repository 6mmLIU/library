package com.library.service;

import com.library.entity.BookCopy;
import com.library.mapper.BookCopyMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for book copy operations.
 */
@Service
public class BookCopyService {
    private final BookCopyMapper mapper;

    public BookCopyService(BookCopyMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Add a new book copy.
     */
    public BookCopy addCopy(BookCopy copy) {
        mapper.insert(copy);
        return copy;
    }

    /**
     * Retrieve all copies.
     */
    public List<BookCopy> listCopies() {
        return mapper.findAll();
    }
}
