package org.redischool.product.services;

import org.redischool.product.model.Attributes;
import org.redischool.product.model.Product;

import java.util.List;

/**
 * Created by ReDI on 12/15/2016.
 */
public interface ProductAttributesSearchService {
    // find List of Products by Attribute Name
    //by Attribute Name
    List<Product> searchProductsByAttributeName(String attName);

    // by Rang Of Attributes Names
    List<Product> searchProductsByAttributesNames(List<String> attNames);

    // by Attribute Name and value
    List<Product> searchProductsByAttributeValueAndName(String attName, String attValue);

    // by Rang Of Attributes Names and Values
    List<Product> searchProductsByAttributesValuesAndNames(List<String> attNames, List<String> attValues);

    // by Attribute Name and Rang of Values
    List<Product> searchProductsByAttributeNameAndRangValues(String attName, List<String> attValues);


    // find List of Products by Attribute Id
    //by Attribute Id
    List<Product> searchProductsByAttributeId(String attId);

    // by Rang Of Attributes Ids
    List<Product> searchProductsByAttributesIds(List<String> attIds);

    // by Attribute Id and value
    List<Product> searchProductsByAttributeValueAndId(String attId, String attValue);

    // by Rang Of Attributes Ids and Values
    List<Product> searchProductsByAttributesValuesAndIds(List<String> attIds, List<String> attValues);

    // by Attribute Id and Rang of Values
    List<Product> searchProductsByAttributeIdAndRangValues(String attId, List<String> attValues);


    // find Attributes by Product Name
    // by Product Name
    List<Attributes> searchAttributesByProductName(String proName);

    // by Rang of Products Names
    List<Attributes> searchAttributesByProductsNames(List<String> proNames);

    // find Attributes by Product Id
    // by Product Id
    List<Attributes> searchAttributesByProductId(String proId);

    // by Products Ids
    List<Attributes> searchAttributesByProductsIds(List<String> proIds);

}
