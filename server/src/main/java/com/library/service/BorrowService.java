package com.library.service;

import com.library.entity.BorrowRecord;
import com.library.mapper.BorrowRecordMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Service for borrow operations.
 */
@Service
public class BorrowService {
    private final BorrowRecordMapper mapper;

    public BorrowService(BorrowRecordMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Borrow a book by creating a record.
     */
    public BorrowRecord borrowBook(BorrowRecord record) {
        record.setBorrowDate(LocalDate.now());
        mapper.insert(record);
        return record;
    }

    /**
     * Return a book.
     */
    public void returnBook(Long recordId) {
        mapper.markReturned(recordId, LocalDate.now());
    }

    public List<BorrowRecord> currentBorrows() {
        return mapper.currentBorrows();
    }
}
