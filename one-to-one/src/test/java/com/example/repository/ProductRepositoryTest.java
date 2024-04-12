package com.example.repository;

import com.example.entity.Product;
import com.example.entity.ProductDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void testListAll() {
		List<Product> products = productRepository.findAll();

		assertThat(products).isNotEmpty();

		products.forEach(System.out::println);
	}

	@Test
	public void testAdd() {
		Product product = new Product();
		ProductDetail productDetail = new ProductDetail();

		product.setName("Iphone");
		product.setPrice(100000);

		product.setProductDetail(productDetail);

		productDetail.setProduct(product);
		productDetail.setDescription("New iPhone version in 2023");
		productDetail.setWeight(2.5f);
		productDetail.setHeight(0.7f);
		productDetail.setLength(4.0f);
		productDetail.setWidth(3.5f);

		Product savedProduct = productRepository.save(product);

		assertThat(savedProduct).isNotNull();

	}
}
