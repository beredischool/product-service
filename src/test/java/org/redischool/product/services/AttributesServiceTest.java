package org.redischool.product.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.redischool.product.model.Attributes;
import org.redischool.product.services.repositories.AttributesRepository;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ReDI on 12/19/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class AttributesServiceTest {

    @Mock
    private AttributesRepository attributesRepository;
    @Mock
    private AttributesSearchService attributesSearchService;

    @InjectMocks
    private AttributesService attributesService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void saveAttributes() throws Exception {
        Attributes attributes = Attributes.builder().name("attName").build();
        Mockito.when(attributesRepository.save(attributes)).thenReturn(attributes.toBuilder().id("attId").build());
        Attributes attributes1 = attributesService.saveAttributes(attributes);
        assertEquals(attributes1.getId(), "attId");
    }

    @Test
    public void getAttributes() throws Exception {
        Attributes attributes = Attributes.builder().id("attId").name("attName").build();
        attributesRepository.save(attributes);
        Mockito.when(attributesRepository.findOne("attId")).thenReturn(attributes);
        Attributes attributes1 = attributesService.getAttributes("attId");
        assertEquals(attributes1, attributes);
    }

    @Test
    public void getAllAttributes() throws Exception {
        List<Attributes> attributes = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            attributes.add(Attributes.builder().id("attId" + i).name("attName" + i).build());
        }

        attributesRepository.save(attributes);
        Mockito.when(attributesRepository.findAll()).thenReturn(attributes);
        List<Attributes> attributes1 = attributesService.getAllAttributes();
        assertEquals(attributes1, attributes);
    }

    @Test
    public void getAllAttributesSorted() throws Exception {
        List<Attributes> attributes = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            attributes.add(Attributes.builder().id("attId" + i).name("attName" + i).build());
        }
        attributesRepository.save(attributes);
        // attributes.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));

        Mockito.when(attributesRepository.findAll(new Sort(Sort.Direction.ASC, "id"))).thenReturn(attributes);
        List<Attributes> attributes1 = attributesService.getAllAttributesSorted("id", true);
        assertEquals(attributes1, attributes);
    }


    @Test
    public void findAttributeByName() throws Exception {
        Attributes attributes = Attributes.builder().id("attId").name("attName").build();
        attributesRepository.save(attributes);
        Mockito.when(attributesSearchService.searchAttributeByName("attName")).thenReturn(attributes);
        Attributes attributes1 = attributesService.findAttributeByName("attName");
        assertEquals(attributes1, attributes);

    }

}