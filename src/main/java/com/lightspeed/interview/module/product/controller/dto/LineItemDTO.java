package com.lightspeed.interview.module.product.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class LineItemDTO {


    private Long id;

    @Min(value = 1, message = "Quantity must be greater than or equal to 1")
    private Long quantity;

    private Long productId;

    private Double totalPrice;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Double discountProportion;
}
