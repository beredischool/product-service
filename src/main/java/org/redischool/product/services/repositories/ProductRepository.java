package org.redischool.product.services.repositories;


import org.redischool.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    Product findByName(String Name);

    @Query("select p from Product p join p.productAttributes pa where pa.attribute.name = ?")
    List<Product> findByAttributeName(String attName);
}

