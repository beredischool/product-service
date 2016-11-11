package org.redischool.product.services.repositories;

import org.redischool.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, String> {
}
