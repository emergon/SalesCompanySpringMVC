
package com.emergon.dao;

import com.emergon.entities.Product;
import java.util.List;
import org.springframework.stereotype.Repository;

/* @author emergon */
@Repository
public class ProductDaoImpl extends SuperDao<Product>{

    @Override
    public List<Product> findAll() {
        String namedQuery = "SELECT p FROM Product p";
        return super.findAll(namedQuery);
    }

}
