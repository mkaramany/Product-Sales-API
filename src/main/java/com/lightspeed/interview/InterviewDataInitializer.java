package com.lightspeed.interview;


import com.lightspeed.interview.module.product.model.Product;
import com.lightspeed.interview.module.product.service.ProductService;
import com.lightspeed.interview.module.product.service.SalesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class InterviewDataInitializer implements CommandLineRunner {

    @Autowired
    ProductService productService;

    @Autowired
    SalesService salesService;

    @Override
    public void run(String... args) throws Exception {
        // Initialize the application with sample data
        Product p1 = Product.builder().price(new BigDecimal(100)).name("Chrome Toaster").build();
        Product p2 = Product.builder().price(new BigDecimal(49.99)).name("Copper Kettle").build();
        Product p3 = Product.builder().price(new BigDecimal(20)).name("Mixing Bowl").build();

        productService.createProduct(p1);
        productService.createProduct(p2);
        productService.createProduct(p3);
        log.info("Data Initialized with CommandLineRunner");
    }
}

