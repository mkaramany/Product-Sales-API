package com.lightspeed.interview.module.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LineItem
{
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private Long quantity;

    Product product;

    private Double totalPrice;

    private Double discountProportion;

}
