package com.library.mapper;

import com.library.entity.BookCopy;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Mapper for book copy operations.
 */
@Mapper
public interface BookCopyMapper {

    @Insert("INSERT INTO book_copy(book_id, code, location) " +
            "VALUES(#{bookId}, #{code}, #{location})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(BookCopy copy);

    @Select("SELECT * FROM book_copy")
    List<BookCopy> findAll();

    @Select("SELECT * FROM book_copy WHERE id=#{id}")
    BookCopy findById(Long id);
}
