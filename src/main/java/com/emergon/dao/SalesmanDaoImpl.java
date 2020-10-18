
package com.emergon.dao;

import com.emergon.entities.Salesman;
import java.util.List;
import org.springframework.stereotype.Repository;

/* @author emergon */
@Repository
public class SalesmanDaoImpl extends SuperDao<Salesman>{

    @Override
    public List<Salesman> findAll() {
        String namedQuery = "SELECT p FROM Salesman p";
        return super.findAll(namedQuery);
    }

}
