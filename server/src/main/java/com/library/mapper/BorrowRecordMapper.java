package com.library.mapper;

import com.library.entity.BorrowRecord;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Mapper for borrow record operations.
 */
@Mapper
public interface BorrowRecordMapper {

    @Insert("INSERT INTO borrow_record(book_id, borrower, borrow_date, return_date) " +
            "VALUES(#{bookId}, #{borrower}, #{borrowDate}, #{returnDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(BorrowRecord record);

    @Select("SELECT * FROM borrow_record WHERE return_date IS NULL")
    List<BorrowRecord> currentBorrows();

    @Update("UPDATE borrow_record SET return_date=#{returnDate} WHERE id=#{id}")
    int markReturned(@Param("id") Long id, @Param("returnDate") java.time.LocalDate returnDate);
}
