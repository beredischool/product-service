package org.redischool.product.services;

import org.redischool.product.model.Attributes;
import org.redischool.product.model.Product;
import org.redischool.product.model.ProductAttributes;
import org.redischool.product.services.repositories.ProductAttributesRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ReDI on 12/15/2016.
 */
public class JpaProductAttributesSearchService implements ProductAttributesSearchService {
    private ProductAttributesRepository productAttributesRepository;

    public JpaProductAttributesSearchService(ProductAttributesRepository productAttributesRepository) {
        this.productAttributesRepository = productAttributesRepository;
    }


    // find List of Products by Attribute Name
    // by Attribute Name
    @Override
    public List<Product> searchProductsByAttributeName(String attName) {
        List<ProductAttributes> productAttributes = productAttributesRepository.findProductsByAttributeName(attName);
/*        List<Product> products = new ArrayList<>();
        for (ProductAttributes pa : productAttributes) {
            products.add(pa.getProduct());
        }*/
        return productAttributes.stream().map(p -> p.getProduct()).collect(Collectors.toList());
    }

    // by Rang Of Attributes Names
    @Override
    public List<Product> searchProductsByAttributesNames(List<String> attNames) {

        List<ProductAttributes> productAttributes = productAttributesRepository.findProductsByAttributesNames(attNames);

        return productAttributes.stream().map(p -> p.getProduct()).collect(Collectors.toList());
    }


    //by Attribute Name und Value
    @Override
    public List<Product> searchProductsByAttributeValueAndName(String attName, String attValue) {
        List<ProductAttributes> productAttributes = productAttributesRepository.findProductsByAttributeValueAndName(attName, attValue);
        return productAttributes.stream().map(p -> p.getProduct()).collect(Collectors.toList());
    }

    // by Rang Of Attributes Names and Values
    @Override
    public List<Product> searchProductsByAttributesValuesAndNames(List<String> attNames, List<String> attValues) {
        List<ProductAttributes> productAttributes = productAttributesRepository.findProductsByAttributesValuesAndNames(attNames, attValues);
        return productAttributes.stream().map(p -> p.getProduct()).collect(Collectors.toList());
        //return new ArrayList<>();
    }


    // by Attribute Name and Rang of Values
    @Override
    public List<Product> searchProductsByAttributeNameAndRangValues(String attName, List<String> attValues) {
        List<ProductAttributes> productAttributes = productAttributesRepository.findProductsByAttributeNameAndRangValues(attName, attValues);
        return productAttributes.stream().map(p -> p.getProduct()).collect(Collectors.toList());
    }


    // find List of Products by Attribute Id
    // by Attribute Id
    @Override
    public List<Product> searchProductsByAttributeId(String attId) {
        List<ProductAttributes> productAttributes = productAttributesRepository.findProductsByAttributeId(attId);
        return productAttributes.stream().map(p -> p.getProduct()).collect(Collectors.toList());
    }

    // by Rang Of Attributes Ids
    @Override
    public List<Product> searchProductsByAttributesIds(List<String> attIds) {
        List<ProductAttributes> productAttributes = productAttributesRepository.findProductsByAttributesIds(attIds);
        return productAttributes.stream().map(p -> p.getProduct()).collect(Collectors.toList());
    }

    // by Attribute Id und Value
    @Override
    public List<Product> searchProductsByAttributeValueAndId(String attId, String attValue) {
        List<ProductAttributes> productAttributes = productAttributesRepository.findProductsByAttributeValueAndId(attId, attValue);
        return productAttributes.stream().map(p -> p.getProduct()).collect(Collectors.toList());
    }

    // by Rang Of Attributes Ids and Values
    @Override
    public List<Product> searchProductsByAttributesValuesAndIds(List<String> attIds, List<String> attValues) {
        List<ProductAttributes> productAttributes = productAttributesRepository.findProductsByAttributesValuesAndIds(attIds, attValues);
        return productAttributes.stream().map(p -> p.getProduct()).collect(Collectors.toList());
    }


    // by Attribute Id and Rang of Values
    @Override
    public List<Product> searchProductsByAttributeIdAndRangValues(String attId, List<String> attValues) {
        List<ProductAttributes> productAttributes = productAttributesRepository.findProductsByAttributeIdAndRangValues(attId, attValues);
        return productAttributes.stream().map(p -> p.getProduct()).collect(Collectors.toList());
    }


    // find Attributes by Product Name
    // by Product Name
    @Override
    public List<Attributes> searchAttributesByProductName(String proName) {
        List<ProductAttributes> productAttributes = productAttributesRepository.findAttributesByProductName(proName);
        return productAttributes.stream().map(p -> p.getAttribute()).collect(Collectors.toList());
    }

    // by Rang of Products Names
    @Override
    public List<Attributes> searchAttributesByProductsNames(List<String> proNames) {
        List<ProductAttributes> productAttributes = productAttributesRepository.findAttributesByProductsNames(proNames);
        return productAttributes.stream().map(p -> p.getAttribute()).collect(Collectors.toList());
    }

    // find Attributes by Product Id
    // by Product Id
    @Override
    public List<Attributes> searchAttributesByProductId(String proId) {
        List<ProductAttributes> productAttributes = productAttributesRepository.findAttributesByProductId(proId);
        return productAttributes.stream().map(p -> p.getAttribute()).collect(Collectors.toList());
    }


    // by Products Ids
    @Override
    public List<Attributes> searchAttributesByProductsIds(List<String> proIds) {
        List<ProductAttributes> productAttributes = productAttributesRepository.findAttributesByProductsIds(proIds);
        return productAttributes.stream().map(p -> p.getAttribute()).collect(Collectors.toList());
    }
}
