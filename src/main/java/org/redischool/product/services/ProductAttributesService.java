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
    private ProductAttributesServiceService productAttributesServiceService;


    public ProductAttributesService(ProductAttributesRepository productAttributesRepository, ProductAttributesServiceService productAttributesServiceService) {
        this.productAttributesRepository = productAttributesRepository;
        this.productAttributesServiceService = productAttributesServiceService;

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
        else
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


    @Transactional
    public List<Product> findProductByAttributeName(String attName) {
        return productAttributesServiceService.searchProductByAttributeName(attName);
    }

    @Transactional
    public List<Product> findProductByAttributesNames(List<String> attNames) {
        return productAttributesServiceService.searchProductByAttributesNames(attNames);
    }

    @Transactional
    public List<Product> findProductByAttributeId(String attId) {
        return productAttributesServiceService.searchProductByAttributeId(attId);
    }

    @Transactional
    public List<Product> findProductByAttributesIds(List<String> attIds) {
        return productAttributesServiceService.searchProductByAttributesIds(attIds);
    }

    @Transactional
    public List<Product> findProductsByAttributeValueAndName(String attName, String attValue) {
        return productAttributesServiceService.searchProductsByAttributeValueAndName(attName, attValue);
    }

    @Transactional
    public List<Product> findProductsByAttributesValuesAndNames(List<String> attNames, List<String> attValues) {
        return productAttributesServiceService.searchProductsByAttributesValuesAndNames(attNames, attValues);
    }

    @Transactional
    public List<Product> findProductsByAttributeValueAndId(String attId, String attValue) {
        return productAttributesServiceService.searchProductsByAttributeValueAndId(attId, attValue);
    }

    @Transactional
    public List<Product> findProductsByAttributesValuesAndIds(List<String> attIds, List<String> attValues) {
        return productAttributesServiceService.searchProductsByAttributesValuesAndIds(attIds, attValues);
    }

    @Transactional
    public List<Product> findProductsByAttributeRangName(String attName, String attValue1, String attValue2) {
        return productAttributesServiceService.searchProductsByAttributeRangName(attName, attValue1, attValue2);
    }

    @Transactional
    public List<Product> findProductsByAttributesRangNames(List<String> attNames, List<String> attValues1, List<String> attValues2) {
        return productAttributesServiceService.searchProductsByAttributesRangNames(attNames, attValues1, attValues2);
    }

    @Transactional
    public List<Product> findProductsByAttributeRangId(String attId, String attValue1, String attValue2) {
        return productAttributesServiceService.searchProductsByAttributeRangId(attId, attValue1, attValue2);
    }

    @Transactional
    public List<Product> findProductsByAttributesRangIds(List<String> attIds, List<String> attValues1, List<String> attValues2) {
        return productAttributesServiceService.searchProductsByAttributesRangIds(attIds, attValues1, attValues2);
    }

    @Transactional
    public List<Attributes> findAttributesByProductName(String proName) {
        return productAttributesServiceService.searchAttributesByProductName(proName);
    }

    @Transactional
    public List<Attributes> findAttributesByProductsNames(List<String> proNames) {
        return productAttributesServiceService.searchAttributesByProductsNames(proNames);
    }

    @Transactional
    public List<Attributes> findAttributesByProductId(String proId) {
        return productAttributesServiceService.searchAttributesByProductId(proId);
    }

    @Transactional
    public List<Attributes> findindAttributesByProductsIds(List<String> proIds) {
        return productAttributesServiceService.searchAttributesByProductsIds(proIds);
    }

}
