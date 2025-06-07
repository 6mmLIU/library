package com.library.service;

import com.library.entity.Book;
import com.library.mapper.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for book operations.
 */
@Service
public class BookService {
    private final BookMapper bookMapper;

    public BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    /**
     * Add a new book into database.
     */
    public Book addBook(Book book) {
        bookMapper.insert(book);
        return book;
    }

    /**
     * Retrieve all books.
     */
    public List<Book> listBooks() {
        return bookMapper.findAll();
    }
}
