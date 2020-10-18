package com.emergon.service;

import com.emergon.dao.SuperDao;
import com.emergon.entities.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional//Takes care of transactions automatically
@Service("productService")//Applied to Service Implementations
public class ProductServiceImpl implements ProductService {

    @Autowired
    SuperDao dao;

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public Product findById(int id) {
        return (Product)dao.findById(Product.class, id);
    }

    @Override
    public void save(Product t) {
        dao.persist(t);
    }

    @Override
    public void remove(int id) {
        dao.remove(Product.class, id);
    }

    @Override
    public List<Product> search(String searchName) {
        String q1 = "FROM Product p WHERE LOWER(pdescr) LIKE :name";
        String q2 = "FROM Product p";
        String [] queries = {q1, q2};
        return dao.findLike(searchName, queries);
    }

    
}
