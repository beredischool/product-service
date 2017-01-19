package org.redischool.product.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.redischool.product.model.Category;
import org.redischool.product.model.Product;
import org.redischool.product.services.repositories.CategoryRepository;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ReDI on 1/8/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

    @Mock
    CategoryRepository categoryRepository;

    @Mock
    CategorySearchService categorySearchService;

    @InjectMocks
    CategoryService categoryService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void saveCategory() throws Exception {

        Category category = Category.builder().name("catName").build();
        Mockito.when(categoryRepository.save(category)).thenReturn(category.toBuilder().id("catId").build());
        Category category1 = categoryService.saveCategory(category);
        assertEquals(category1.getId(), "catId");
    }

    @Test
    public void getCategory() throws Exception {
        Category category = Category.builder().id("catId").name("catName").build();

        Mockito.when(categoryRepository.findOne("catId")).thenReturn(category);
        Category category1 = categoryService.getCategory("catId");
        assertEquals(category1, category);
    }

    @Test
    public void getAllCategories() throws Exception {
        List<Category> categories = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            categories.add(Category.builder().id("catId" + i).name("catName" + i).build());
        }

        Mockito.when(categoryRepository.findAll()).thenReturn(categories);
        List<Category> categories1 = categoryService.getAllCategories();
        assertEquals(categories1, categories);
    }

    @Test
    public void getAllCategoriesSorted() throws Exception {
        List<Category> categories = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            categories.add(Category.builder().id("catId" + i).name("catName" + i).build());
        }

        Mockito.when(categoryRepository.findAll(new Sort(Sort.Direction.ASC, "id"))).thenReturn(categories);
        List<Category> categories1 = categoryService.getAllCategoriesSorted("id", true);
        assertEquals(categories1, categories);
    }


    @Test
    public void findCategoryByName() throws Exception {
        Category category = Category.builder().id("catId").name("catName").build();
        Mockito.when(categorySearchService.searchCategoryByName("catName")).thenReturn(category);
        Category category1 = categoryService.findCategoryByName("catName");
        assertEquals(category1, category);
    }


    @Test
    public void getProducts() throws Exception {
        Product dell = Product.builder().id("dell1").name("Dell").build();
        Product asus = Product.builder().id("asus1").name("Asus").build();
        Product hp = Product.builder().id("hp1").name("HP").build();

        Category category = Category.builder().id("catId").name("catName").product(dell).product(asus).product(hp).build();
        Mockito.when(categoryRepository.findOne("catId")).thenReturn(category);
        List<Product> products = categoryService.getProducts("catId");
        assertEquals(products, category.getProducts());
    }

}