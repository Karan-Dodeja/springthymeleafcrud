package com.karan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karan.entity.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
