package org.redischool.product.services;

import org.redischool.product.model.Attributes;
import org.redischool.product.services.repositories.AttributesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ReDI on 02/12/2016.
 */
public class AttributesService {
    private AttributesRepository attributesRepository;
    private AttributesSearchService attributesSearchService;


    @Autowired
    public AttributesService(AttributesRepository attributesRepository, AttributesSearchService attributesSearchService) {
        this.attributesRepository = attributesRepository;
        this.attributesSearchService = attributesSearchService;
    }


    @Transactional
    public Attributes saveAttributes(Attributes attributes) {
        return attributesRepository.save(attributes);
    }

    @Transactional
    public Attributes getAttributes(String id) {
        return attributesRepository.findOne(id);
    }

    @Transactional
    public List<Attributes> getAllAttributes() {
        return new ArrayList<>(attributesRepository.findAll());
    }

    @Transactional
    private List<Attributes> getAllAttributesSorted(String sortBy, boolean dir) {
        if (dir)
            return new ArrayList<>(attributesRepository.findAll(new Sort(Sort.Direction.ASC, sortBy)));
        else
            return new ArrayList<>(attributesRepository.findAll(new Sort(Sort.Direction.DESC, sortBy)));
    }


    @Transactional
    private void deleteAttribute(String id) {
        attributesRepository.delete(id);
    }

    @Transactional
    private void deleteAllAttributes() {
        attributesRepository.deleteAll();
    }

    @Transactional
    Attributes findCategoryByName(String attName) {
        return attributesSearchService.searchAttributeByName(attName);
    }


}
