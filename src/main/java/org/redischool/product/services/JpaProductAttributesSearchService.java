package org.redischool.product.services;

import org.redischool.product.model.Attributes;
import org.redischool.product.model.Product;
import org.redischool.product.services.repositories.ProductAttributesRepository;

import java.util.List;

/**
 * Created by ReDI on 12/15/2016.
 */
public class JpaProductAttributesSearchService implements ProductAttributesServiceService {
    private ProductAttributesRepository productAttributesRepository;

    public JpaProductAttributesSearchService(ProductAttributesRepository productAttributesRepository) {
        this.productAttributesRepository = productAttributesRepository;
    }


    @Override
    public List<Product> searchProductByAttributeName(String attName) {
        return productAttributesRepository.findProductByAttributeName(attName);
    }

    @Override
    public List<Product> searchProductByAttributesNames(List<String> attNames) {
        return productAttributesRepository.findProductByAttributesNames(attNames);
    }

    @Override
    public List<Product> searchProductByAttributeId(String attId) {
        return productAttributesRepository.findProductByAttributeId(attId);
    }

    @Override
    public List<Product> searchProductByAttributesIds(List<String> attIds) {
        return productAttributesRepository.findProductByAttributesIds(attIds);
    }

    @Override
    public List<Product> searchProductsByAttributeValueAndName(String attName, String attValue) {
        return productAttributesRepository.findProductsByAttributeValueAndName(attName, attValue);
    }

    @Override
    public List<Product> searchProductsByAttributesValuesAndNames(List<String> attNames, List<String> attValues) {
        return productAttributesRepository.findProductsByAttributesValuesAndNames(attNames, attValues);
    }

    @Override
    public List<Product> searchProductsByAttributeValueAndId(String attId, String attValue) {
        return productAttributesRepository.findProductsByAttributeValueAndId(attId, attValue);
    }

    @Override
    public List<Product> searchProductsByAttributesValuesAndIds(List<String> attIds, List<String> attValues) {
        return productAttributesRepository.findProductsByAttributesValuesAndIds(attIds, attValues);
    }

    @Override
    public List<Product> searchProductsByAttributeRangName(String attName, String attValue1, String attValue2) {
        return productAttributesRepository.findProductsByAttributeRangName(attName, attValue1, attValue2);
    }

    @Override
    public List<Product> searchProductsByAttributesRangNames(List<String> attNames, List<String> attValues1, List<String> attValues2) {
        return productAttributesRepository.findProductsByAttributesRangNames(attNames, attValues1, attValues2);
    }

    @Override
    public List<Product> searchProductsByAttributeRangId(String attId, String attValue1, String attValue2) {
        return productAttributesRepository.findProductsByAttributeRangId(attId, attValue1, attValue2);
    }

    @Override
    public List<Product> searchProductsByAttributesRangIds(List<String> attIds, List<String> attValues1, List<String> attValues2) {
        return productAttributesRepository.findProductsByAttributesRangIds(attIds, attValues1, attValues2);
    }

    @Override
    public List<Attributes> searchAttributesByProductName(String proName) {
        return productAttributesRepository.findAttributesByProductName(proName);
    }

    @Override
    public List<Attributes> searchAttributesByProductsNames(List<String> proNames) {
        return productAttributesRepository.findAttributesByProductsNames(proNames);
    }

    @Override
    public List<Attributes> searchAttributesByProductId(String proId) {
        return productAttributesRepository.findAttributesByProductId(proId);
    }

    @Override
    public List<Attributes> searchAttributesByProductsIds(List<String> proIds) {
        return productAttributesRepository.findAttributesByProductsIds(proIds);
    }
}
