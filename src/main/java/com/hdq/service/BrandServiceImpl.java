package com.hdq.service;

import com.hdq.entity.Brand;
import com.hdq.form.BrandCreateForm;
import com.hdq.form.BrandUpdateForm;
import com.hdq.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements  IBrandService{
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Page<Brand> getAllPage(Pageable pageable) {
        return null;
    }

    @Override
    public void save(BrandCreateForm form) {

        String brand = form.getBrand();

        Brand brand1 = new Brand();
        brand1.setBrandName(brand);

        brandRepository.save(brand1);
    }

    @Override
    public void update(Integer id, BrandUpdateForm form) {

        Brand  brand = brandRepository.getBrandByBrandId(id);

        brand.setBrandName(form.getBrand());
        brandRepository.save(brand);
    }

    @Override
    public void deleteById(Integer id) {
        brandRepository.deleteById(id);
    }
}
