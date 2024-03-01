package com.lightspeed.interview.module.product.service;

import com.lightspeed.interview.module.product.controller.dto.SalesDTO;
import com.lightspeed.interview.module.product.model.Sales;

public interface SalesService {

    Sales createSales(SalesDTO salesDTO);

    Sales createSalesWithDiscount(SalesDTO salesDTO);
}
