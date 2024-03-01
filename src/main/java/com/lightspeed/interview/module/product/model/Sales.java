package com.lightspeed.interview.module.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sales {

    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private List<LineItem> lineItems;

    private Double totalSalesPrice;

    private Double overallSaleDiscount;

}
