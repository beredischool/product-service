package org.redischool.product.services;

import org.redischool.product.model.Attributes;
import org.redischool.product.services.repositories.AttributesRepository;
import org.springframework.stereotype.Service;

/**
 * Created by ReDI on 02/12/2016.
 */
@Service
public class JpaAttributeSearchService implements AttributesSearchService {

    private final AttributesRepository attributesRepository;

    public JpaAttributeSearchService(AttributesRepository attributesRepository) {
        this.attributesRepository = attributesRepository;
    }

    @Override
    public Attributes searchAttributeByName(String attName) {
        return attributesRepository.findByName(attName);
    }
}
