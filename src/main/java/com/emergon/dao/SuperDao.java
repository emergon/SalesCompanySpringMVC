package com.emergon.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
//@Transactional
public class SuperDao<T> {

    //private final Class<T> persistentClass;
    //@SuppressWarnings("unchecked")
//    public SuperDao() {
//        //this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//    }
    @Autowired
    private SessionFactory sessionFactory;
//    private Session s;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
//
//    public T findById(Class<T> type, Object id) {
//        return getSession().find(type, id);
//        //return getSession().find(persistentClass, id);
//    }
//    
//    protected void closeSession(){
//        s.close();
//    }

//    public void persist(T entity) {
//        getSession().persist(entity);
//    }
//
//    public T update(T entity) {
//         return (T)getSession().merge(entity);
//    }
//
//    public void delete(T entity) {
//        getSession().remove(entity);
//    }
}
