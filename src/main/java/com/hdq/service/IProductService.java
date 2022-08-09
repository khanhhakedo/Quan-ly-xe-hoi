package com.hdq.service;

import com.hdq.entity.Product;
import com.hdq.form.ProductCreateForm;
import com.hdq.form.ProductUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    public Product getProductById(Integer id);

    Page<Product> getAllPage(Pageable pageable);

    List<Product> findByNameLike(String namelike);

    List<Product> findByPriceLessThan(Float price);

    List<Product> findByPriceGreaterThan(Float price);

    public  void  save(ProductCreateForm form);

    public  void update(Integer id, ProductUpdateForm form);

    public void deleteById(Integer id);

    public void deleteByBrandId(Integer id);

    List<Product> getProductDESC ();

    List<Product> getProductASC ();

    List<Product> getProductByPrice(Float price);


}
