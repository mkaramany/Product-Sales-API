package com.lightspeed.interview;

import com.lightspeed.interview.module.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class InterviewApplicationTests {

	@Autowired
	ProductService productService;

	@Test
	void findAllProductsShouldReturnANonEmptyList() {
		assertThat(productService.listProducts()).isNotEmpty();
	}
	@Test
	void getProductByExistingIdThrowsException(){
		 assertDoesNotThrow(()-> productService.findById(1l));
	}

	@Test
	void getProductByUnexistingIdThrowsException(){
		assertThrows(NoSuchElementException.class, ()-> productService.findById(-3l));
	}

}