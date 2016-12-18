package org.redischool.product.services;

import org.redischool.product.model.Product;
import org.redischool.product.services.repositories.ProductRepository;

/**
 * Created by ReDI on 12/15/2016.
 */
public class JpaProductSearchService implements ProductsSearchService {

    private final ProductRepository productRepository;

    public JpaProductSearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product searchProductByName(String proName) {
        return productRepository.findProductByName(proName);
    }
}
