package com.lightspeed.interview.module.product.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SalesDTO {

    private Long id;

    @Valid
    private List<LineItemDTO> lineItemDTOS;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double totalSalesPrice;

    @Positive(message = "Overall Discount must be a positive value")
    private Double overallSaleDiscount;

}
