package com.emergon.dao;

import com.emergon.entities.Book;
import java.util.List;

public interface BookDao {

    void save(Book book);

    List<Book> findAll();
    
}
