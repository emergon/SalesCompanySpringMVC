package com.emergon.service;

import com.emergon.dao.BookDao;
import com.emergon.entities.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional//Takes care of transactions automatically
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao cdao;

    @Override
    public void saveBook(Book book) {
        cdao.save(book);
    }

    
    @Override
    public List<Book> findAllBooks() {
        return cdao.findAll();
    }

}
