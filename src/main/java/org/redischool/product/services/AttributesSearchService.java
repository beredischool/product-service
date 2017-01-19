package org.redischool.product.services;

import org.redischool.product.model.Attributes;

/**
 * Created by ReDI on 02/12/2016.
 */
public interface AttributesSearchService {

    Attributes searchAttributeByName(String attName);
}
