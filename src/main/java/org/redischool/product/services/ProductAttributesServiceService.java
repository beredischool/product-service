package org.redischool.product.services;

import org.redischool.product.model.Attributes;
import org.redischool.product.model.Product;

import java.util.List;

/**
 * Created by ReDI on 12/15/2016.
 */
public interface ProductAttributesServiceService {
    List<Product> searchProductByAttributeName(String attName);

    List<Product> searchProductByAttributesNames(List<String> attNames);

    List<Product> searchProductByAttributeId(String attId);

    List<Product> searchProductByAttributesIds(List<String> attIds);

    List<Product> searchProductsByAttributeValueAndName(String attName, String attValue);

    List<Product> searchProductsByAttributesValuesAndNames(List<String> attNames, List<String> attValues);

    List<Product> searchProductsByAttributeValueAndId(String attId, String attValue);

    List<Product> searchProductsByAttributesValuesAndIds(List<String> attIds, List<String> attValues);

    List<Product> searchProductsByAttributeRangName(String attName, String attValue1, String attValue2);

    List<Product> searchProductsByAttributesRangNames(List<String> attNames, List<String> attValues1, List<String> attValues2);

    List<Product> searchProductsByAttributeRangId(String attId, String attValue1, String attValue2);

    List<Product> searchProductsByAttributesRangIds(List<String> attIds, List<String> attValues1, List<String> attValues2);

    List<Attributes> searchAttributesByProductName(String proName);

    List<Attributes> searchAttributesByProductsNames(List<String> proNames);

    List<Attributes> searchAttributesByProductId(String proId);

    List<Attributes> searchAttributesByProductsIds(List<String> proIds);

}
