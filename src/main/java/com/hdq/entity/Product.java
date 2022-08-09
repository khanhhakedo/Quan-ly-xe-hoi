package com.hdq.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String image;
    private String description;

//    1 hang co nhieu san pham
    @ManyToOne
    @JoinColumn(name = "BrandId")
    private Brand brand;

    private String category;
    private Float price;
    private Integer countInStock;
    private Float rating;
    private Integer numReviews;

    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;


    @Column(name = "UpdateDate")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updateDate;



}

