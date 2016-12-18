package org.redischool.product.services.repositories;

import org.redischool.product.model.Attributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AttributesRepository extends JpaRepository<Attributes, String> {

    @Query
    Attributes findAttributeByName(String attName);

}
