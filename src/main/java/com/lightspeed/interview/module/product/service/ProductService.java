package com.lightspeed.interview.module.product.service;

import com.lightspeed.interview.module.product.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> listProducts();

    Product createProduct(Product product);

    Product findById(Long id);
}
