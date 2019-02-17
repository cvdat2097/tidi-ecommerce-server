package org.springlab.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springlab.api.routes.RouteProduct;
import org.springlab.config.constant.Constant;
import org.springlab.core.service.ProductService;
import org.springlab.model.entity.Brand;

@RestController
@RequestMapping(Constant.BASE_URL + RouteProduct.ROOT)
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(RouteProduct.BRAND)
    private List<Brand> getAllBrandsHandler() {
        return productService.getAllBrands();
    }

}
