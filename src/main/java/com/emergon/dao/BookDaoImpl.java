package com.emergon.dao;

import com.emergon.entities.Book;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository//Apply it in DAO implementations
public class BookDaoImpl  implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public void save(Book book) {
        getSession().saveOrUpdate(book);
    }
    
    @Override
    public List<Book> findAll() {
        Query q = getSession().createQuery("SELECT b FROM Book b");
        List<Book> list = q.getResultList();
        //closeSession();
        return list;
    }

}
