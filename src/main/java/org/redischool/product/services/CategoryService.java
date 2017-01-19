package org.redischool.product.services;

import org.redischool.product.model.Category;
import org.redischool.product.model.Product;
import org.redischool.product.services.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ReDI on 11/10/2016.
 */
@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    private CategorySearchService categorySearchService;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategorySearchService categorySearchService) {
        this.categoryRepository = categoryRepository;
        this.categorySearchService = categorySearchService;
    }


    @Transactional
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    public Category getCategory(String id) {
        return categoryRepository.findOne(id);
    }

    @Transactional
    public List<Category> getAllCategories() {
        return new ArrayList<>(categoryRepository.findAll());
    }

    @Transactional
    public List<Category> getAllCategoriesSorted(String sortBy, boolean dir) {
        if (dir)
            return new ArrayList<>(categoryRepository.findAll(new Sort(Sort.Direction.ASC, sortBy)));

        return new ArrayList<>(categoryRepository.findAll(new Sort(Sort.Direction.DESC, sortBy)));
    }

    @Transactional
    public List<Product> getProducts(String id) {
        return new ArrayList<>(categoryRepository.findOne(id).getProducts());
    }

    @Transactional
    private void deleteCategory(String id) {
        categoryRepository.delete(id);
    }


    @Transactional
    private void deleteAllCategories() {
        categoryRepository.deleteAll();
    }

    @Transactional
    public Category findCategoryByName(String catName) {
        return categorySearchService.searchCategoryByName(catName);
    }

}
