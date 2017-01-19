package org.redischool.product.services;

import org.redischool.product.model.Category;
import org.redischool.product.model.Product;
import org.redischool.product.services.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductsSearchService productsSearchService;


    @Autowired
    public ProductService(ProductRepository productRepository, ProductsSearchService productsSearchService) {
        this.productRepository = productRepository;
        this.productsSearchService = productsSearchService;
    }


    public String generateId() {
        return UUID.randomUUID().toString();
    }

    @Transactional
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public Product getProduct(String id) {
        Product product = productRepository.findOne(id);
        product.getCategories().size();
        product.getProductAttributes().size();
        return product;
    }

    @Transactional
    public List<Product> getAllProducts() {
        return new ArrayList<>(productRepository.findAll());
    }

    @Transactional
    public List<Product> getAllProductsSorted(String sortBy, boolean dir) {
        if (dir)
            return new ArrayList<>(productRepository.findAll(new Sort(Sort.Direction.ASC, sortBy)));

        return new ArrayList<>(productRepository.findAll(new Sort(Sort.Direction.DESC, sortBy)));
    }

    @Transactional
    public List<Category> getCategories(String id) {
        return new ArrayList<>(productRepository.findOne(id).getCategories());
    }

    @Transactional
    private void deleteProduct(String id) {
        productRepository.delete(id);
    }


    @Transactional
    private void deleteAllProducts() {
        productRepository.deleteAll();
    }

    @Transactional
    Product findProductByName(String proName) {
        return productsSearchService.searchProductByName(proName);
    }

    @Transactional
    public List<Product> findProductsByAttributeName(String attName) {
        return productsSearchService.saerchProductsByAttributeName(attName);
    }
}
