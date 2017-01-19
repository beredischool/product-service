package org.redischool.product.services.repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redischool.product.model.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ReDI on 11/14/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AttributesRepositoryTest {

    @Autowired
    private AttributesRepository attributesRepository;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        attributesRepository.deleteAll();
    }

    @Test
    public void shouldSaveAnAttribute() {
        Attributes attributes = Attributes.builder().id("test").name("test").build();
        Attributes attributes1 = attributesRepository.save(attributes);
        assertEquals(attributes, attributes1);
    }

    @Test
    public void shouldThrowException() {
        Attributes attributes = Attributes.builder().id("test").name("test").build();
        attributesRepository.save(attributes);

        Attributes attributes1 = Attributes.builder().id("test").name("test").build();
        attributesRepository.save(attributes1);
    }

    @Test
    public void shouldFindAllData() {

        List<Attributes> attributes = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            attributes.add(i, Attributes.builder().id("test" + i).name("test" + i).build());
        }
        attributesRepository.save(attributes);
        List<Attributes> attributes1 = attributesRepository.findAll();
        assertEquals(attributes, attributes1);
    }


    @Test
    public void shouldFindAllDataSorted() {

        List<Attributes> attributes = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 10; i >= 0; i--) {
            attributes.add(Attributes.builder().id("test" + i).name("test" + i).build());
        }
        attributesRepository.save(attributes);
        attributes.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
        List<Attributes> attributes2 = attributesRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
        assertEquals(attributes2, attributes);
    }

    @Test
    public void shouldFindOnId() {

        List<Attributes> attributes = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            attributes.add(Attributes.builder().id("test" + i).name("test" + i).build());
        }
        attributesRepository.save(attributes);
        Attributes attributes2 = attributesRepository.findOne("test5");
        assertEquals(attributes2, attributes.get(5));
    }

    @Test
    public void shouldDeleteOnId() {

        List<Attributes> attributes = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            attributes.add(Attributes.builder().id("test" + i).name("test" + i).build());
        }
        attributesRepository.save(attributes);

        attributesRepository.delete("test5");

        List<Attributes> attributes1 = attributesRepository.findAll();

        attributes.remove(attributes.get(5));

        assertEquals(attributes1, attributes);
    }


    @Test
    public void shouldDeleteEntity() {

        List<Attributes> attributes = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            attributes.add(Attributes.builder().id("test" + i).name("test" + i).build());
        }
        attributesRepository.save(attributes);

        attributesRepository.delete(attributes.get(6));

        List<Attributes> attributes1 = attributesRepository.findAll();

        attributes.remove(attributes.get(6));

        assertEquals(attributes1, attributes);
    }


    @Test
    public void shouldDeleteAllEntity() {

        List<Attributes> attributes = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            attributes.add(Attributes.builder().id("test" + i).name("test" + i).build());
        }
        attributesRepository.save(attributes);

        attributesRepository.delete(attributes);

        List<Attributes> attributes1 = attributesRepository.findAll();

        attributes1.removeAll(attributes1);

        assertEquals(attributes1, attributes);
    }
}