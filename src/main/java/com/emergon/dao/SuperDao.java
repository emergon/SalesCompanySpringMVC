package com.emergon.dao;

import com.emergon.entities.Customer;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class SuperDao<T> implements InterfaceDao<T>{

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T findById(Class<T> type, Object id) {
        return getSession().find(type, id);
    }

    public List<T> findAll(String query){
        List<T> list = getSession().createQuery(query).getResultList();
        return list;
    }
    
    @Override
    public void persist(T entity) {
        getSession().saveOrUpdate(entity);
    }
    
    @Override
    public <T> void remove(Class<T> type, int id) {
        Session session = getSession();
        T t = session.load(type, id);
        session.delete(t);
    }

    @Override
    public List<T> findLike(String name, String [] queries){
        TypedQuery<T> q;
        if (name != null && name.trim().length() > 0) {
            String query = queries [0];
            q = getSession().createQuery(query);
            q.setParameter("name", "%" + name.toLowerCase() + "%");
        } else {
            q = getSession().createQuery(queries [1]);
        }
        List<T> list = q.getResultList();
        return list;
    }
    
    
}
