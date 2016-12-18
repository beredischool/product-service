package org.redischool.product.services;

import org.redischool.product.model.Category;

/**
 * Created by ReDI on 02/12/2016.
 */
public interface CategorySearchService {

    Category searchCategoryByName(String catName);
}
