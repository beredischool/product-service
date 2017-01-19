package org.redischool.product.services.repositories;

import org.redischool.product.model.ProductAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ReDI on 11/10/2016.
 */
public interface ProductAttributesRepository extends JpaRepository<ProductAttributes, String> {

    // find List of Products-Attribute by Attribute Name
    // by Attribute Name
    @Query("select pa from ProductAttributes pa where pa.attribute.name = :attName")
    List<ProductAttributes> findProductsByAttributeName(@Param("attName") String attName);

    // by Rang Of Attributes Names
    @Query("select pa from ProductAttributes pa where pa.attribute.name in :attNames")
    List<ProductAttributes> findProductsByAttributesNames(@Param("attNames") List<String> attNames);

    //by Attribute Name and Value
    @Query("select pa from ProductAttributes pa where pa.attribute.name = :attName AND pa.value = :attValue")
    List<ProductAttributes> findProductsByAttributeValueAndName(@Param("attName") String attName, @Param("attValue") String attValue);


    // by Rang Of Attributes Names and Values
    @Query("select pa from ProductAttributes pa where pa.attribute.name in :attNames and pa.value in :attValues")
    List<ProductAttributes> findProductsByAttributesValuesAndNames(@Param("attNames") List<String> attNames, @Param("attValues") List<String> attValues);


    // by Attribute Name and Rang of Values
    @Query("select pa from ProductAttributes pa where pa.attribute.name = :attName AND pa.value in :attValues")
    List<ProductAttributes> findProductsByAttributeNameAndRangValues(@Param("attName") String attName, @Param("attValues") List<String> attValues);


    // find List of Products-Attribute by Attribute Id
    // by Attribute Id
    @Query("select pa from ProductAttributes pa where pa.attribute.id = :attId")
    List<ProductAttributes> findProductsByAttributeId(@Param("attId") String attId);

    // by Rang Of Attributes Ids
    @Query("select pa from ProductAttributes pa where pa.attribute.id in :attIds")
    List<ProductAttributes> findProductsByAttributesIds(@Param("attIds") List<String> attIds);

    // by Attribute Id and Value
    @Query("select pa from ProductAttributes pa where pa.attribute.id = :attId AND pa.value = :attValue")
    List<ProductAttributes> findProductsByAttributeValueAndId(@Param("attId") String attId, @Param("attValue") String attValue);

    // by Rang Of Attributes Ids and Values
    @Query("select pa from ProductAttributes pa where pa.attribute.id in :attIds and pa.value in :attValues")
    List<ProductAttributes> findProductsByAttributesValuesAndIds(@Param("attIds") List<String> attIds, @Param("attValues") List<String> attValues);

    // by Attribute Id and Rang of Values
    @Query("select pa from ProductAttributes pa where pa.attribute.id = :attId AND pa.value in :attValues")
    List<ProductAttributes> findProductsByAttributeIdAndRangValues(@Param("attId") String attId, @Param("attValues") List<String> attValues);


    // find Attributes by Product Name
    // by Product Name
    @Query("select pa from ProductAttributes pa where pa.product.name = :proName")
    List<ProductAttributes> findAttributesByProductName(@Param("proName") String proName);

    // by Rang of Products Names
    @Query("select pa from ProductAttributes pa where pa.product.name in :proNames")
    List<ProductAttributes> findAttributesByProductsNames(@Param("proNames") List<String> proNames);


    // find Attributes by Product Id
    // by Product Id
    @Query("select pa from ProductAttributes pa where pa.product.id = :proId")
    List<ProductAttributes> findAttributesByProductId(@Param("proId") String proId);

    // by Products Ids
    @Query("select pa from ProductAttributes pa where pa.product.id in :proIds")
    List<ProductAttributes> findAttributesByProductsIds(@Param("proIds") List<String> proIds);
}

