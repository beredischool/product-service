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
import org.redischool.product.model.Category;
import org.redischool.product.model.Product;
import org.redischool.product.model.ProductAttributes;
import org.redischool.product.services.repositories.ProductRepository;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ReDI on 1/9/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
    @Mock
    ProductRepository productRepository;

    @Mock
    ProductsSearchService productsSearchService;

    @InjectMocks
    ProductService productService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void saveProduct() throws Exception {
        Product product = Product.builder().name("proName").build();
        Mockito.when(productRepository.save(product)).thenReturn(product.toBuilder().id("proId").build());
        Product product1 = productService.saveProduct(product);
        assertEquals(product1.getId(), "proId");
    }

    @Test
    public void getProduct() throws Exception {
        Product product = Product.builder().id("proId").name("proName").build();
        Mockito.when(productRepository.findOne("proName")).thenReturn(product);
        Product product1 = productService.getProduct("proName");
        assertEquals(product1, product);
    }

    @Test
    public void getAllProducts() throws Exception {
        List<Product> products = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            products.add(Product.builder().id("proId" + i).name("proName" + i).build());
        }

        Mockito.when(productRepository.findAll()).thenReturn(products);
        List<Product> products1 = productService.getAllProducts();
        assertEquals(products1, products);
    }


    @Test
    public void getAllProductsSorted() throws Exception {
        List<Product> products = new ArrayList<>(); // List is interface can not be instanced

        for (int i = 0; i < 10; i++) {
            products.add(Product.builder().id("proId" + i).name("proName" + i).build());
        }

        Mockito.when(productRepository.findAll(new Sort(Sort.Direction.ASC, "id"))).thenReturn(products);
        List<Product> products1 = productService.getAllProductsSorted("id", true);
        assertEquals(products1, products);
    }


    @Test
    public void getCategories() throws Exception {
        Category c1 = Category.builder().id("catId1").name("catName1").build();
        Category c2 = Category.builder().id("catId2").name("catName2").build();

        List<Category> categories = new ArrayList<>();
        categories.add(c1);
        categories.add(c2);

        Product product = Product.builder().id("proId").name("proName").categories(categories).build();
        Mockito.when(productRepository.findOne("proId").getCategories()).thenReturn(product.getCategories());
        List<Category> categories1 = productService.getCategories("proId");
        assertEquals(categories1, product.getCategories());
    }

    @Test
    public void findProductByName() throws Exception {
        Product product = Product.builder().id("proId").name("proName").build();
        Mockito.when(productsSearchService.searchProductByName("proName")).thenReturn(product);
        Product product1 = productService.getProduct("proName");
        assertEquals(product1, product);
    }

    @Test
    public void findProductsByAttributeName() throws Exception {
        Attributes attributes = Attributes.builder().id("attId").name("attName").build();

        List<Product> products = new ArrayList<>(); // List is interface can not be instanced
        List<ProductAttributes> productAttributes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            products.add(Product.builder().id("proId" + i).name("proName" + i).build());
            productAttributes.add(ProductAttributes.builder().id("paId" + i).attribute(attributes).product(products.get(i)).value("100" + i).build());
            //products.get(i).toBuilder().productAttributes()
        }


    }

}