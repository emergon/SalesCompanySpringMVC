package com.emergon.service;

import com.emergon.dao.SuperDao;
import com.emergon.entities.Product;
import com.emergon.entities.Salesman;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional//Takes care of transactions automatically
@Service("salesmanService")//Applied to Service Implementations
public class SalesmanServiceImpl implements SuperService<Salesman> {

    @Autowired
    SuperDao<Salesman> dao;

    @Override
    public List<Salesman> findAll() {
        return dao.findAll();
    }

    @Override
    public Salesman findById(int id) {
        return dao.findById(Salesman.class, id);
    }

    @Override
    public void save(Salesman t) {
        dao.persist(t);
    }

    @Override
    public void remove(int id) {
        dao.remove(Salesman.class, id);
    }

    @Override
    public List<Salesman> search(String searchName) {
        String q1 = "FROM Salesman p WHERE LOWER(sname) LIKE :name OR LOWER(scity) LIKE :name";
        String q2 = "FROM Salesman p";
        String [] queries = {q1, q2};
        return dao.findLike(searchName, queries);
    }

    
}
