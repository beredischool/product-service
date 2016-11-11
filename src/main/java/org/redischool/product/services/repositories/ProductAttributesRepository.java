package org.redischool.product.services.repositories;

import org.redischool.product.model.ProductAttributes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ReDI on 11/10/2016.
 */
public interface ProductAttributesRepository extends JpaRepository<ProductAttributes, String> {
}
