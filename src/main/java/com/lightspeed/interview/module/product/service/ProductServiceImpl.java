package com.lightspeed.interview.module.product.service;

import com.lightspeed.interview.module.product.model.Product;
import com.lightspeed.interview.module.product.repository.ProductCommandRepository;
import com.lightspeed.interview.module.product.repository.ProductQueryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductQueryRepository productQueryRepository;

    @Autowired
    ProductCommandRepository productCommandRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> listProducts() {
        log.info("Listing all products");
        return productQueryRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        log.info("Creating a new Product with details: {}" , product);
        return productCommandRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        log.info("Calling findById with id: {}" , id);
        Optional<Product> product = productQueryRepository.findById(id);
        return product.get();
    }


}
