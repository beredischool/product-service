package org.redischool.product.services;

import org.redischool.product.model.Attributes;
import org.redischool.product.model.Product;
import org.redischool.product.model.ProductAttributes;
import org.redischool.product.services.repositories.ProductAttributesRepository;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ReDI on 12/15/2016.
 */
public class ProductAttributesService {
    private ProductAttributesRepository productAttributesRepository;
    private ProductAttributesSearchService productAttributesSearchService;


    public ProductAttributesService(ProductAttributesRepository productAttributesRepository, ProductAttributesSearchService productAttributesSearchService) {
        this.productAttributesRepository = productAttributesRepository;
        this.productAttributesSearchService = productAttributesSearchService;

    }

    @Transactional
    public ProductAttributes saveProductAttributeValue(ProductAttributes productAttributes) {
        return productAttributesRepository.save(productAttributes);
    }


    @Transactional
    public List<ProductAttributes> getAllProductAttributes(String id) {
        return new ArrayList<>(productAttributesRepository.findAll());
    }

    @Transactional
    private List<ProductAttributes> getAllProductAttributesSorted(String sortBy, boolean dir) {
        if (dir)
            return new ArrayList<>(productAttributesRepository.findAll(new Sort(Sort.Direction.ASC, sortBy)));

        return new ArrayList<>(productAttributesRepository.findAll(new Sort(Sort.Direction.DESC, sortBy)));
    }

    @Transactional
    private void deleteProductAttributes(String id) {
        productAttributesRepository.delete(id);
    }

    @Transactional
    private void deleteAllProductAttributes() {
        productAttributesRepository.deleteAll();
    }


    // find List Of Products by Attribute Name
    // by Attribute Name
    @Transactional
    public List<Product> findProductsByAttributeName(String attName) {
        return productAttributesSearchService.searchProductsByAttributeName(attName);
    }

    // by Rang Of Attributes Names
    @Transactional
    public List<Product> findProductsByAttributesNames(List<String> attNames) {
        return productAttributesSearchService.searchProductsByAttributesNames(attNames);
    }


    // by Attribute Name and Value
    @Transactional
    public List<Product> findProductsByAttributeValueAndName(String attName, String attValue) {
        return productAttributesSearchService.searchProductsByAttributeValueAndName(attName, attValue);
    }

    // by Rang Of Attributes Names and Values
    @Transactional
    public List<Product> findProductsByAttributesValuesAndNames(List<String> attNames, List<String> attValues) {
        return productAttributesSearchService.searchProductsByAttributesValuesAndNames(attNames, attValues);
    }

    // by Attribute Name and Rang of Values
    @Transactional
    public List<Product> findProductsByAttributeNameAndRangValues(String attName, List<String> attValues) {
        return productAttributesSearchService.searchProductsByAttributeNameAndRangValues(attName, attValues);
    }


    // find Products by Attribute Id
    //by Attribute Id
    @Transactional
    public List<Product> findProductsByAttributeId(String attId) {
        return productAttributesSearchService.searchProductsByAttributeId(attId);
    }

    // by Rang Of Attributes Ids
    @Transactional
    public List<Product> findProductsByAttributesIds(List<String> attIds) {
        return productAttributesSearchService.searchProductsByAttributesIds(attIds);
    }

    // by Attribute Id and Value
    @Transactional
    public List<Product> findProductsByAttributeValueAndId(String attId, String attValue) {
        return productAttributesSearchService.searchProductsByAttributeValueAndId(attId, attValue);
    }

    // by Rang Of Attributes Ids and Values
    @Transactional
    public List<Product> findProductsByAttributesValuesAndIds(List<String> attIds, List<String> attValues) {
        return productAttributesSearchService.searchProductsByAttributesValuesAndIds(attIds, attValues);
    }

    // by Attribute Id and Rang of Values
    @Transactional
    public List<Product> findProductsByAttributeIdAndRangValues(String attId, List<String> attValues) {
        return productAttributesSearchService.searchProductsByAttributeIdAndRangValues(attId, attValues);
    }


    // find Attributes by Product Name
    // by Product Name
    @Transactional
    public List<Attributes> findAttributesByProductName(String proName) {
        return productAttributesSearchService.searchAttributesByProductName(proName);
    }

    // by Rang of Products Names
    @Transactional
    public List<Attributes> findAttributesByProductsNames(List<String> proNames) {
        return productAttributesSearchService.searchAttributesByProductsNames(proNames);
    }


    // find Attributes by Product Id
    // by Product Id
    @Transactional
    public List<Attributes> findAttributesByProductId(String proId) {
        return productAttributesSearchService.searchAttributesByProductId(proId);
    }

    // by Products Ids
    @Transactional
    public List<Attributes> findindAttributesByProductsIds(List<String> proIds) {
        return productAttributesSearchService.searchAttributesByProductsIds(proIds);
    }

}
