package org.redischool.product.services.repositories;

import org.redischool.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CategoryRepository extends JpaRepository<Category, String> {

    @Query
    Category findCategoryByName(String catName);

}
