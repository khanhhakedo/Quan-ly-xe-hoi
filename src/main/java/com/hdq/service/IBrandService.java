package com.hdq.service;

import com.hdq.entity.Brand;
import com.hdq.entity.Product;
import com.hdq.form.BrandCreateForm;
import com.hdq.form.BrandUpdateForm;
import com.hdq.form.ProductCreateForm;
import com.hdq.form.ProductUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBrandService {
    Page<Brand> getAllPage(Pageable pageable);

    public  void  save(BrandCreateForm form);

    public  void update(Integer id, BrandUpdateForm form);

    public void deleteById(Integer id);
}
