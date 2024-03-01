package com.lightspeed.interview.module.product.repository;

import com.lightspeed.interview.module.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductQueryRepository extends JpaRepository<Product, Long> {

}
