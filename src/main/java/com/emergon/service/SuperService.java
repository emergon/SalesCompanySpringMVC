
package com.emergon.service;

import java.util.List;

/* @author emergon */
public interface SuperService<T> {

    List<T> findAll();
    
    T findById(int id);

    void save(T t);

    void remove(int id);
    
    List<T> search(String searchName);
}
