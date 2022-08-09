package com.hdq.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BrandId")
    private Integer brandId;

    private String brandName;

    @OneToMany(mappedBy = "brand")
    private List<Product> products;
}
