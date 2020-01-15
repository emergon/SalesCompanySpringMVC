package com.emergon.service;

import com.emergon.entities.Book;
import java.util.List;

public interface BookService {
    
    void saveBook(Book customer);

    List<Book> findAllBooks();
    
}
