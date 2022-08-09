package com.hdq.repository;

import com.hdq.entity.Brand;
import com.hdq.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    //    get theo id
    public Brand getBrandByBrandId(Integer id);
}
