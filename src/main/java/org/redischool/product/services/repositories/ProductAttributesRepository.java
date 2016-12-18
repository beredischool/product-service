package org.redischool.product.services.repositories;

import org.redischool.product.model.Attributes;
import org.redischool.product.model.Product;
import org.redischool.product.model.ProductAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by ReDI on 11/10/2016.
 */
public interface ProductAttributesRepository extends JpaRepository<ProductAttributes, String> {

    @Query
    List<Product> findProductByAttributeName(String attName);

    @Query
    List<Product> findProductByAttributesNames(List<String> attNames);

    @Query
    List<Product> findProductByAttributeId(String attId);

    @Query
    List<Product> findProductByAttributesIds(List<String> attIds);

    @Query
    List<Product> findProductsByAttributeValueAndName(String attName, String attValue);

    @Query
    List<Product> findProductsByAttributesValuesAndNames(List<String> attNames, List<String> attValues);

    @Query
    List<Product> findProductsByAttributeValueAndId(String attId, String attValue);

    @Query
    List<Product> findProductsByAttributesValuesAndIds(List<String> attIds, List<String> attValues);

    @Query
    List<Product> findProductsByAttributeRangName(String attName, String attValue1, String attValue2);

    @Query
    List<Product> findProductsByAttributesRangNames(List<String> attNames, List<String> attValues1, List<String> attValues2);

    @Query
    List<Product> findProductsByAttributeRangId(String attId, String attValue1, String attValue2);

    @Query
    List<Product> findProductsByAttributesRangIds(List<String> attIds, List<String> attValues1, List<String> attValues2);

    @Query
    List<Attributes> findAttributesByProductName(String proName);

    @Query
    List<Attributes> findAttributesByProductsNames(List<String> proNames);

    @Query
    List<Attributes> findAttributesByProductId(String proId);

    @Query
    List<Attributes> findAttributesByProductsIds(List<String> proIds);
}

