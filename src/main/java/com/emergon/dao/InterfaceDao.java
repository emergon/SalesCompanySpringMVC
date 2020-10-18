
package com.emergon.dao;

import java.util.List;

/* @author emergon */
public interface InterfaceDao <T>{

    T findById(Class<T> type, Object id);

    List<T> findAll();
    
    void persist(T entity);
    
    <T> void remove(Class<T> type, int id);
    
    public List<T> findLike(String name, String[] queries);
}
