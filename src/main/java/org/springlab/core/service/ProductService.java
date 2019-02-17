package org.springlab.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springlab.model.entity.Brand;
import org.springlab.model.repository.BrandRepository;

@Service
public class ProductService {
    @Autowired
    private BrandRepository brandRepo;

    public List<Brand> getAllBrands() {
        Iterable<Brand> brandIterable = brandRepo.findAll();

        ArrayList<Brand> brands = new ArrayList<Brand>();

        brandIterable.forEach(brand -> brands.add(brand));

        return brands;
    }
}
