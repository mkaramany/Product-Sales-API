package com.lightspeed.interview.module.product.controller;


import com.lightspeed.interview.module.product.controller.dto.SalesDTO;
import com.lightspeed.interview.module.product.model.Sales;
import com.lightspeed.interview.module.product.service.ProductService;
import com.lightspeed.interview.module.product.service.SalesService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Validated
@RequestMapping(value = "/api/sales/")
public class SalesController {

    @Autowired
    SalesService salesService;
    
    @Autowired
    ProductService productService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping()
    @Operation(summary = "Create a new Sales")
    public ResponseEntity<Sales> add(@Valid @RequestBody SalesDTO salesDTO, BindingResult bindingResult) {
        Sales sales = salesService.createSales(salesDTO);
        return ResponseEntity.created(null).body(sales);
    }

    @PostMapping("/discount")
    @Operation(summary = "Create a new Sales with flat Dollar amount discount")
    public ResponseEntity<Sales> addWithDiscount(@Valid @RequestBody SalesDTO salesDTO, BindingResult bindingResult) {
        Sales sales = salesService.createSalesWithDiscount(salesDTO);
        return ResponseEntity.created(null).body(sales);
    }
}
