package com.library.mapper;

import com.library.entity.Book;
import com.library.entity.BookCopy;
import com.library.entity.BorrowRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=MYSQL",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password="
})
@Transactional
class MapperMappingTest {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookCopyMapper bookCopyMapper;
    @Autowired
    private BorrowRecordMapper borrowRecordMapper;

    @Test
    void bookCopyMapping() {
        Book book = new Book();
        book.setTitle("t");
        book.setAuthor("a");
        book.setCategory("c");
        book.setLocation("l");
        bookMapper.insert(book);

        BookCopy copy = new BookCopy();
        copy.setBookId(book.getId());
        copy.setCode("CODE1");
        copy.setLocation("loc");
        bookCopyMapper.insert(copy);

        BookCopy loaded = bookCopyMapper.findById(copy.getId());
        assertNotNull(loaded);
        assertEquals(copy.getBookId(), loaded.getBookId());
        assertEquals(copy.getCode(), loaded.getCode());
    }

    @Test
    void borrowRecordMapping() {
        Book book = new Book();
        book.setTitle("t2");
        book.setAuthor("a2");
        book.setCategory("c2");
        book.setLocation("l2");
        bookMapper.insert(book);
        BookCopy copy = new BookCopy();
        copy.setBookId(book.getId());
        copy.setCode("CODE2");
        copy.setLocation("loc2");
        bookCopyMapper.insert(copy);

        BorrowRecord record = new BorrowRecord();
        record.setCopyId(copy.getId());
        record.setBorrower("someone");
        record.setBorrowDate(LocalDate.now());
        record.setReturnDate(null);
        borrowRecordMapper.insert(record);

        List<BorrowRecord> list = borrowRecordMapper.currentBorrows();
        assertFalse(list.isEmpty());
        BorrowRecord loaded = list.get(0);
        assertEquals(record.getCopyId(), loaded.getCopyId());
        assertNotNull(loaded.getBorrowDate());
        assertNull(loaded.getReturnDate());
    }
}
