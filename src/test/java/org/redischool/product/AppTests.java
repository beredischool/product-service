package org.redischool.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redischool.product.model.Category;
import org.redischool.product.model.Product;
import org.redischool.product.services.repositories.CategoryRepository;
import org.redischool.product.services.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {

	@Autowired
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;

	@Test
	public void contextLoads() {
		assertTrue(true);

		Product dell = Product.builder().name("Dell").id("dell1").build();
		Product asus = Product.builder().name("Asus").id("asus1").build();
		Product hp = Product.builder().name("HP").id("hp1").build();
		Product toshiba = Product.builder().name("Toshiba").id("toshiba1").build();
		Product fillips = Product.builder().name("Fillips").id("fillips1").build();

		Set<Product> products = null;
		products.add(dell);
		products.add(asus);
		products.add(hp);

		Category laptop = Category.builder().name("Laptops").id("lap").products(products).build();
		Category screen = Category.builder().name("Screen").id("scr").product(toshiba).product(fillips).build();

		dell.builder().category(laptop).build();
		asus.builder().category(laptop).build();
		hp.builder().category(laptop).build();
		toshiba.builder().category(screen).build();
		fillips.builder().category(screen).build();



		productRepository.save(dell);
		productRepository.save(asus);
		productRepository.save(hp);
		productRepository.save(toshiba);
		productRepository.save(fillips);

		categoryRepository.save(laptop);
		categoryRepository.save(screen);

		Product read = productRepository.findOne("dell1");
		Product read1 = productRepository.findOne("asus1");
		Product read2 = productRepository.findOne("hp1");
		Product read3 = productRepository.findOne("toshiba1");
		Product read4 = productRepository.findOne("fillips1");

		Category read5 = categoryRepository.findOne("lap");
		Category read6 = categoryRepository.findOne("scr");

		assertEquals(dell, read);
		assertEquals(asus, read1);
		assertEquals(hp, read2);
		assertEquals(toshiba, read3);
		assertEquals(fillips, read4);

		assertEquals(laptop, read5);
		assertEquals(screen, read6);
	}

}
