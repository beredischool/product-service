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

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductsSearchService productsSearchService;


    @Autowired
    public ProductService(ProductRepository productRepository, ProductsSearchService productsSearchService) {
        this.productRepository = productRepository;
        this.productsSearchService = productsSearchService;
    }


    @Transactional
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public Product getProduct(String id) {
        return productRepository.findOne(id);
    }

    @Transactional
    public List<Product> getAllProducts() {
        return new ArrayList<>(productRepository.findAll());
    }

    @Transactional
    private List<Product> getAllProductsSorted(String sortBy, boolean dir) {
        if (dir)
            return new ArrayList<>(productRepository.findAll(new Sort(Sort.Direction.ASC, sortBy)));
        else
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


}
