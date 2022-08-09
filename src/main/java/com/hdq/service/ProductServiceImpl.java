package com.hdq.service;

import com.hdq.entity.Brand;
import com.hdq.entity.Product;
import com.hdq.form.ProductCreateForm;
import com.hdq.form.ProductUpdateForm;
import com.hdq.repository.BrandRepository;
import com.hdq.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class ProductServiceImpl implements  IProductService{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Product getProductById(Integer id) {
        Product product = productRepository.getProductById(id);
        return product;
    }

    @Override
    public Page<Product> getAllPage(Pageable pageable) {

        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> findByNameLike(String namelike) {
        List<Product> products = productRepository.findByNameLike(namelike);
        return products;
    }

    @Override
    public List<Product> findByPriceLessThan(Float price) {
        List<Product> products = productRepository.findByPriceLessThan(price);
        return products;
    }

    @Override
    public List<Product> findByPriceGreaterThan(Float price) {
        List<Product> products = productRepository.findByPriceGreaterThan(price);
        return products;
    }

    @Override
    public void save(ProductCreateForm form) {
        String name = form.getName();
        String image = form.getImage();
        String description = form.getDescription();
        Integer brandId = form.getBrand();
        String category = form.getCategory();
        Float price = form.getPrice();
        Integer countInStock =form.getCountInStock();
        Float rating = form.getRating();
        Integer numReviews = form.getNumReviews();


        Product product = new Product();

        product.setName(name);
        product.setImage(image);
        product.setDescription(description);

        Brand brand = brandRepository.getBrandByBrandId(brandId);
        product.setBrand(brand);

        product.setPrice(price);
        product.setCountInStock(countInStock);
        product.setRating(rating);
        product.setNumReviews(numReviews);
        product.setCategory(category);
        productRepository.save(product);

    }

    @Override
    public void update(Integer id, ProductUpdateForm form) {

        Product product = productRepository.getProductById(id);
        Brand brand = brandRepository.getBrandByBrandId(form.getBrand());

        product.setName(form.getName());
        product.setImage(form.getImage());
        product.setDescription(form.getDescription());
        product.setBrand(brand);
        product.setCategory(form.getCategory());
        product.setPrice(form.getPrice());
        product.setCountInStock(form.getCountInStock());
        product.setRating(form.getRating());
        product.setNumReviews(form.getNumReviews());

        productRepository.save(product);

    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteByBrandId(Integer id) {
        productRepository.deleteByBrandId(id);
    }

    @Override
    public List<Product> getProductDESC() {
        List<Product> products = productRepository.getProductDESC();
        return products;
    }


    @Override
    public List<Product> getProductASC() {
        List<Product> products = productRepository.getProductASC();
        return products;
    }

    @Override
    public List<Product> getProductByPrice(Float price) {
        return null;
    }

}
