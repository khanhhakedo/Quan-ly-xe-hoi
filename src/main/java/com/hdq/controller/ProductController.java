package com.hdq.controller;

import com.hdq.Dto.ProductDto;
import com.hdq.entity.Product;
import com.hdq.form.ProductCreateForm;
import com.hdq.form.ProductUpdateForm;
import com.hdq.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/products")
public class ProductController {

    @Autowired
    private IProductService IProductService;


    @GetMapping()
    public ResponseEntity<?> getAllProducts(Pageable pageable) {
        Page<Product> products = IProductService.getAllPage(pageable);
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setPrice(product.getPrice());
            productDto.setBrand(product.getBrand().getBrandId());
            productDto.setName(product.getName());
            productDto.setImage(product.getImage());
            productDto.setDescription(product.getDescription());
            productDto.setRating(product.getRating());
            productDto.setCountInStock(product.getCountInStock());
            productDto.setNumReviews(product.getNumReviews());
            productDto.setCategory(product.getCategory());
            productDtos.add(productDto);
        }
        return new ResponseEntity<>(productDtos, HttpStatus.OK);

    }

    @GetMapping("/top")
    public ResponseEntity<?> getProductsDESC() {
        List<Product> products = IProductService.getProductDESC();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setPrice(product.getPrice());
            productDto.setBrand(product.getBrand().getBrandId());
            productDto.setName(product.getName());
            productDto.setImage(product.getImage());
            productDto.setDescription(product.getDescription());
            productDto.setRating(product.getRating());
            productDto.setCountInStock(product.getCountInStock());
            productDto.setNumReviews(product.getNumReviews());
            productDto.setCategory(product.getCategory());
            productDtos.add(productDto);

        }
        return new ResponseEntity<>(productDtos, HttpStatus.OK);

    }

    @GetMapping("/down")
    public ResponseEntity<?> getProductsASC() {
        List<Product> products = IProductService.getProductASC();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setPrice(product.getPrice());
            productDto.setBrand(product.getBrand().getBrandId());
            productDto.setName(product.getName());
            productDto.setImage(product.getImage());
            productDto.setDescription(product.getDescription());
            productDto.setRating(product.getRating());
            productDto.setCountInStock(product.getCountInStock());
            productDto.setNumReviews(product.getNumReviews());
            productDto.setCategory(product.getCategory());
            productDtos.add(productDto);

        }
        return new ResponseEntity<>(productDtos, HttpStatus.OK);

    }

    @GetMapping("/pricemax")
    public ResponseEntity<?> getProductsPriceMax() {
        List<Product> products = IProductService.getProductASC();

        Product product = products.get(products.size()-1);
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setPrice(product.getPrice());
        productDto.setBrand(product.getBrand().getBrandId());
        productDto.setName(product.getName());
        productDto.setImage(product.getImage());
        productDto.setDescription(product.getDescription());
        productDto.setRating(product.getRating());
        productDto.setCountInStock(product.getCountInStock());
        productDto.setNumReviews(product.getNumReviews());
        productDto.setCategory(product.getCategory());

        return new ResponseEntity<>(productDto, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Integer id) {
        Product product = IProductService.getProductById(id);

        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setPrice(product.getPrice());
        productDto.setBrand(product.getBrand().getBrandId());
        productDto.setName(product.getName());
        productDto.setImage(product.getImage());
        productDto.setDescription(product.getDescription());
        productDto.setRating(product.getRating());
        productDto.setCountInStock(product.getCountInStock());
        productDto.setNumReviews(product.getNumReviews());

        productDto.setCategory(product.getCategory());
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    // them Product moi
    @PostMapping()
    public ResponseEntity<?> createProduct(@RequestBody ProductCreateForm form) {
        IProductService.save(form);
        return new ResponseEntity<String>("Create successfully!", HttpStatus.OK);
    }

    // Sua Product theo productId
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable(name = "id") Integer id, @RequestBody ProductUpdateForm form) {
        IProductService.update(id,form);
        return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
    }

    // Xoa Product theo id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") Integer id) {
        IProductService.deleteById(id);
        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
    }
}
