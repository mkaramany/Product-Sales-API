package com.lightspeed.interview.module.product.controller;


import com.lightspeed.interview.module.product.controller.dto.ProductDTO;
import com.lightspeed.interview.module.product.model.Product;
import com.lightspeed.interview.module.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@Validated
@RequestMapping(value = "/api/products/")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping()
    @Operation(summary = "List all Products")
    public ResponseEntity<List<ProductDTO>> list() {
        List<Product> products = productService.listProducts();
        List<ProductDTO> productDTOList = products.stream().map(product ->
                modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(productDTOList);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "find a product by id")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return ResponseEntity.ok(productDTO);
    }

    @PostMapping()
    @Operation(summary = "Create a new Product")
    public ResponseEntity<ProductDTO> add(@Valid @RequestBody ProductDTO productDTO, BindingResult bindingResult) {
        Product product = productService.createProduct(modelMapper.map(productDTO, Product.class));
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/" + product.getId()).build().toUri();
        return ResponseEntity.created(location)
                .body(modelMapper.map(product, ProductDTO.class));
    }
}
