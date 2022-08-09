package com.hdq.repository;

import com.hdq.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
//    get all theo page
    @Query("SELECT a FROM Product a ")
    Page<Product> findAll(Pageable pageable);

//    get theo id
    public Product getProductById(Integer id);

//    get theo ten sp gan dung
    List<Product> findByNameLike(String namelike);

//    danh sach sp theo gia it hon nhap vao
    List<Product> findByPriceLessThan(Float price);

//    danh sach sp theo gia lon hon nhap vao
    List<Product> findByPriceGreaterThan(Float price);

//    get theo gia giam dan
    @Modifying
    @Query("SELECT p FROM Product AS p  ORDER BY p.price DESC  nulls last " )
    List<Product> getProductDESC ();

    //    get theo gia tangdan
    @Modifying
    @Query("SELECT p FROM Product AS p  ORDER BY p.price ASC  nulls last " )
    List<Product> getProductASC ();

    //    get theo gia max
    List<Product> getProductByPrice(Float price);


//    get list price

    @Modifying
    @Query("SELECT p.price FROM Product AS p  " )
    List<Product> getProductPrice ();

    @Modifying
    @Query("DELETE FROM Product AS p WHERE p.brand.brandId = :parId")
    void deleteByBrandId(@Param("parId") Integer id);
}
