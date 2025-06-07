package com.library.mapper;

import com.library.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Mapper for basic book CRUD operations.
 */
@Mapper
public interface BookMapper {

    @Insert("INSERT INTO book(title, author, category, location) VALUES(#{title}, #{author}, #{category}, #{location})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Book book);

    @Select("SELECT * FROM book")
    List<Book> findAll();

    @Select("SELECT * FROM book WHERE id=#{id}")
    Book findById(Long id);
}
