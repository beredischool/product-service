package org.redischool.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redischool.product.model.Product;
import org.redischool.product.services.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void contextLoads() {
		Product test = Product.builder().name("Test").id("string11").build();
		productRepository.save(test);
		Product read = productRepository.findOne("string11");
		assertEquals(test, read);
	}

}
