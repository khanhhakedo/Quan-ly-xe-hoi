package com.hdq.form;

import lombok.Data;

@Data
public class ProductCreateForm {

    private String name = "ProductNew";
    private String image = "/images/sample.jpg";
    private String description;
    private Integer brand;
    private String category;
    private Float price;
    private Integer countInStock;
    private Float rating;
    private Integer numReviews;
}
