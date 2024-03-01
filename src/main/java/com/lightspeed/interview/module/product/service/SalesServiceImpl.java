package com.lightspeed.interview.module.product.service;

import com.lightspeed.interview.module.product.controller.dto.LineItemDTO;
import com.lightspeed.interview.module.product.controller.dto.SalesDTO;
import com.lightspeed.interview.module.product.model.LineItem;
import com.lightspeed.interview.module.product.model.Product;
import com.lightspeed.interview.module.product.model.Sales;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class SalesServiceImpl implements SalesService {

    @Autowired
    ProductService productService;

    @Override
    public Sales createSales(SalesDTO salesDTO) {
        log.info("Creating a new Sales with details: {}" , salesDTO);
        Sales sales = getSales(salesDTO);
        sales.setTotalSalesPrice(sales.getLineItems().stream().mapToDouble(LineItem::getTotalPrice).sum());
        return sales;
    }

    @Override
    public Sales createSalesWithDiscount(SalesDTO salesDTO) {
        log.info("Creating a new  flat dollar discounted Sales with details: {}" , salesDTO);
        Sales sales = getSales(salesDTO);
        sales.setTotalSalesPrice(sales.getLineItems().stream().mapToDouble(LineItem::getTotalPrice).sum());
        updateDiscountProportion(sales);
        return sales;
    }

    private Sales getSales(SalesDTO salesDTO) {
        return Sales.builder()
                .lineItems(getLineItems(salesDTO.getLineItemDTOS()))
                .overallSaleDiscount(salesDTO.getOverallSaleDiscount())
                .build();
    }


    private  List<LineItem> getLineItems(List<LineItemDTO> lineItemDTOS) {
        return lineItemDTOS.stream().map(lineItemDTO -> getLineItem(lineItemDTO)).collect(Collectors.toList());
    }

    private LineItem getLineItem(LineItemDTO lineItemDTO) {
        Product product = productService.findById(lineItemDTO.getProductId());
        return LineItem.builder().
                product(product)
                .totalPrice(product.getPrice().doubleValue() * lineItemDTO.getQuantity() )
                .quantity(lineItemDTO.getQuantity()).build();
    }

    private double calculateDiscountPerUnit(Sales sales) {
        return sales.getOverallSaleDiscount() / sales.getTotalSalesPrice();
    }

    private void updateDiscountProportion(Sales sales){
        double discountPerUnit = calculateDiscountPerUnit(sales);
        sales.getLineItems().stream().forEach(l -> l.setDiscountProportion(discountPerUnit * l.getTotalPrice()));

    }



}
