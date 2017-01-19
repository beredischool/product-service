package org.redischool.product.services;

import org.redischool.product.model.Category;
import org.redischool.product.services.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

/**
 * Created by ReDI on 12/15/2016.
 */
@Service
public class JpaCategorySearchService implements CategorySearchService {

    private final CategoryRepository categoryRepository;

    public JpaCategorySearchService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category searchCategoryByName(String catName) {
        return categoryRepository.findByName(catName);
    }
}
