package com.codingshuttle.jpatutorial;

import com.codingshuttle.jpatutorial.entities.ProductEntity;
import com.codingshuttle.jpatutorial.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpatutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository() {
		ProductEntity productEntity = ProductEntity.builder().sku("nestle234").title("nestle chocolate").price(BigDecimal.valueOf(100.50)).quantity(5).build();
		System.out.println(productRepository.save(productEntity));
	}

	@Test
	void getRepository() {
		List<ProductEntity> entities  = productRepository.findByTitle("nestle chocolate");
		System.out.println(entities);
	}

	@Test
	void getSingleFromRepository() {
		Optional<ProductEntity> entity  = productRepository.findByTitleAndPrice("nestle chocolate", BigDecimal.valueOf(100.50));
		System.out.println(entity);
	}

}
