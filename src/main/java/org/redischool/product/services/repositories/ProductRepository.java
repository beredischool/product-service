package org.redischool.product.services.repositories;


import org.redischool.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, String> {

    @Query
    Product findProductByName(String proName);

}

