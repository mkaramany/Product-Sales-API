package com.lightspeed.interview.module.product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //as future improvement, don't allow non-numeric values
    @NonNull
    private String name;

    @NonNull
    private BigDecimal price;
}
