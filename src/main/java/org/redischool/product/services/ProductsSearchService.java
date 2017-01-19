package org.redischool.product.services;

import org.redischool.product.model.Product;

import java.util.List;


/**
 * Created by ReDI on 02/12/2016.
 */
public interface ProductsSearchService {

    Product searchProductByName(String proName);

    List<Product> saerchProductsByAttributeName(String attName);
}
