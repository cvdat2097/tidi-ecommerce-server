package org.springlab.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springlab.model.entity.Brand;
import org.springlab.model.entity.Product;
import org.springlab.model.repository.BrandRepository;
import org.springlab.model.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private BrandRepository brandRepo;

    @Autowired
    private ProductRepository productRepo;

    public List<Brand> getAllBrands() {
        Iterable<Brand> brandIterable = brandRepo.findAll();

        ArrayList<Brand> brands = new ArrayList<Brand>();

        brandIterable.forEach(brand -> brands.add(brand));

        return brands;
    }

    public Product getProduct(Integer productId) throws Exception {
        try {
            Product foundProduct = productRepo.findById(productId).get();
            
            if (foundProduct == null) {
                throw new NoSuchElementException("Product is not found");
            }
            
            return foundProduct;
        } catch (NoSuchElementException exc) {
            throw new Exception("Product is not found");

        }
    }
}
