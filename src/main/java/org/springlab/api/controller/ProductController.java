package org.springlab.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springlab.api.dto.shared.ProductDTO;
import org.springlab.api.routes.RouteProduct;
import org.springlab.config.constant.Constant;
import org.springlab.config.constant.ReturnCode;
import org.springlab.core.service.ProductService;
import org.springlab.model.entity.Brand;
import org.springlab.model.entity.Product;

@RestController
@RequestMapping(Constant.BASE_URL + RouteProduct.ROOT)
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(RouteProduct.BRAND)
    private List<Brand> getAllBrandsHandler() {
        return productService.getAllBrands();
    }

    @GetMapping(RouteProduct.ONE_PRODUCT)
    private ProductDTO getOneProduct(@RequestParam(name = "id") Integer productId) {
        try {
            Product foundProduct = productService.getProduct(productId);

            ProductDTO prodDTO = new ProductDTO(ReturnCode.SUCCESS, "Product found",foundProduct);
            
            return prodDTO;
        } catch (Exception exc) {
            return new ProductDTO(ReturnCode.FAILURE, exc.getMessage());
        }
    }
}
