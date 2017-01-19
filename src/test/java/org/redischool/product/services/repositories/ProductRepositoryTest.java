package org.redischool.product.services.repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redischool.product.model.Product;
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
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        productRepository.deleteAll();
    }

    @Test
    public void shouldSaveProduct() {
        Product product = Product.builder().id("test").name("test").description("test").build();

        Product product1 = productRepository.save(product);
        assertEquals(product1, product);
    }

    @Test
    public void shouldThrowException() {
        Product product = Product.builder().id("test").name("test").description("test").build();
        productRepository.save(product);

        Product product1 = Product.builder().id("test").name("test").description("test").build();
        productRepository.save(product1);
    }

    @Test
    public void shouldFindAllData() {

        List<Product> products = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            products.add(i, Product.builder().id("test" + i).name("test" + i).description("test" + i).build());
        }
        productRepository.save(products);
        List<Product> products1 = productRepository.findAll();
        assertEquals(products1, products);
    }


    @Test
    public void shouldFindAllDataSorted() {

        List<Product> products = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 10; i >= 0; i--) {
            products.add(Product.builder().id("test" + i).name("test" + i).description("test" + i).build());
        }
        productRepository.save(products);
        products.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
        List<Product> products1 = productRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
        assertEquals(products1, products);
    }

    @Test
    public void shouldFindOnId() {

        List<Product> products = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            products.add(Product.builder().id("test" + i).name("test" + i).description("test" + i).build());
        }
        productRepository.save(products);
        Product product1 = productRepository.findOne("test5");
        assertEquals(product1, products.get(5));
    }

    @Test
    public void shouldDeleteOnId() {

        List<Product> products = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            products.add(Product.builder().id("test" + i).name("test" + i).description("test" + i).build());
        }
        productRepository.save(products);

        productRepository.delete("test5");

        List<Product> products1 = productRepository.findAll();

        products.remove(products.get(5));

        assertEquals(products1, products);
    }


    @Test
    public void shouldDeleteEntity() {

        List<Product> products = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            products.add(Product.builder().id("test" + i).name("test" + i).description("test" + i).build());
        }
        productRepository.save(products);

        productRepository.delete(products.get(6));

        List<Product> products1 = productRepository.findAll();

        products.remove(products.get(6));

        assertEquals(products1, products);
    }


    @Test
    public void shouldDeleteAllEntity() {

        List<Product> products = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            products.add(Product.builder().id("test" + i).name("test" + i).description("test" + i).build());

        }
        productRepository.save(products);

        productRepository.delete(products);

        List<Product> products1 = productRepository.findAll();

        products1.removeAll(products1);

        assertEquals(products1, products);
    }

}