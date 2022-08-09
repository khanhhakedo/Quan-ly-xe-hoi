package com.hdq.form;

import lombok.Data;

@Data
public class ProductUpdateForm {

    private String name;
    private String image;
    private String description;
    private Integer brand;
    private String category;
    private Float price;
    private Integer countInStock;
    private Float rating;
    private Integer numReviews;
}
