package com.hdq.controller;

import com.hdq.form.BrandCreateForm;
import com.hdq.form.BrandUpdateForm;
import com.hdq.form.ProductCreateForm;
import com.hdq.form.ProductUpdateForm;
import com.hdq.service.IBrandService;
import com.hdq.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/brands")
public class BrandController {

    @Autowired
    private IBrandService iBrandService;

    @Autowired
    private IProductService iProductService;

    // them Product moi
    @PostMapping()
    public ResponseEntity<?> createBrand(@RequestBody BrandCreateForm form) {
        iBrandService.save(form);
        return new ResponseEntity<String>("Create successfully!", HttpStatus.OK);
    }

    // Sua Product theo productId
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateBrand(@PathVariable(name = "id") Integer id, @RequestBody BrandUpdateForm form) {
        iBrandService.update(id,form);
        return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
    }

    // Xoa  theo id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") Integer id) {
        iProductService.deleteByBrandId(id);
        iBrandService.deleteById(id);
        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
    }
}
