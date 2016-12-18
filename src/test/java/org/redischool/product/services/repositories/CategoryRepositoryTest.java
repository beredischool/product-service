package org.redischool.product.services.repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redischool.product.model.Category;
import org.redischool.product.model.Product;
import org.redischool.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by ReDI on 11/14/2016.
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        categoryRepository.deleteAll();


    }


    Set<Product> createProducts() {
        Product dell = Product.builder().id("dell1").name("Dell").build();
        Product asus = Product.builder().id("asus1").name("Asus").build();
        Product hp = Product.builder().id("hp1").name("HP").build();

        Set<Product> products = new HashSet<>();
        products.add(dell);
        products.add(asus);
        products.add(hp);

        productRepository.save(products);

        return products;
    }


    @Test
    public void shouldSaveCategory() {

        Category category = Category.builder().id("lap").name("Laptops").products(createProducts()).build();
        Category category1 = categoryRepository.save(category);
        assertEquals(category1, category);

        Product products = productRepository.findAll().get(0);
        Set<Category> categories = new HashSet<>();
        categories.add(category);
        categories.add(category1);
        products.toBuilder().categories(categories).build();
        Product products1 = productRepository.save(products);
        for (int i = 0; i < 3; i++) {
            System.out.println(products1.getCategories().isEmpty());
        }

/*        List<Category> categories = productService.getCategories("dell1");
        assertEquals(category1, categories.get(0));*/
    }

    @Test
    public void shouldThrowException() {
        Category category = Category.builder().id("test").name("test").build();
        categoryRepository.save(category);

        Category category1 = Category.builder().id("test").name("test").build();
        categoryRepository.save(category1);
    }

    @Test
    public void shouldFindAllData() {

        List<Category> categories = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            categories.add(i, Category.builder().id("test" + i).name("test" + i).build());
        }
        categoryRepository.save(categories);
        List<Category> categories1 = categoryRepository.findAll();
        assertEquals(categories1, categories);
    }


    @Test
    public void shouldFindAllDataSorted() {

        List<Category> categories = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 10; i >= 0; i--) {
            categories.add(Category.builder().id("test" + i).name("test" + i).build());
        }
        categoryRepository.save(categories);
        categories.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
        List<Category> categories1 = categoryRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
        assertEquals(categories1, categories);
    }

    @Test
    public void shouldFindOnId() {

        List<Category> categories = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            categories.add(Category.builder().id("test" + i).name("test" + i).build());
        }
        categoryRepository.save(categories);
        Category category1 = categoryRepository.findOne("test5");
        assertEquals(category1, categories.get(5));
    }

    @Test
    public void shouldDeleteOnId() {

        List<Category> categories = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            categories.add(Category.builder().id("test" + i).name("test" + i).build());
        }
        categoryRepository.save(categories);

        categoryRepository.delete("test5");

        List<Category> categories1 = categoryRepository.findAll();

        categories.remove(categories.get(5));

        assertEquals(categories1, categories);
    }


    @Test
    public void shouldDeleteEntity() {

        List<Category> categories = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            categories.add(Category.builder().id("test" + i).name("test" + i).build());
        }
        categoryRepository.save(categories);

        categoryRepository.delete(categories.get(6));

        List<Category> categories1 = categoryRepository.findAll();

        categories.remove(categories.get(6));

        assertEquals(categories1, categories);
    }


    @Test
    public void shouldDeleteAllEntity() {

        List<Category> categories = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            categories.add(Category.builder().id("test" + i).name("test" + i).build());
        }
        categoryRepository.save(categories);

        categoryRepository.delete(categories);

        List<Category> categories1 = categoryRepository.findAll();

        categories1.removeAll(categories1);

        assertEquals(categories1, categories);
    }

}