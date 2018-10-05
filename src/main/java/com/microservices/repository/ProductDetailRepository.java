package com.microservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.microservices.domain.ProductDetail;

public interface ProductDetailRepository extends CrudRepository<ProductDetail, Long> {
	
	//@Query("SELECT p FROM ProductDetails p WHERE LOWER(p.productType) = LOWER(:productType)")
    public List<ProductDetail> findByproductType(@Param("productType") String productType);

}
