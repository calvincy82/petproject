package com.calvin.login.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calvin.login.example.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
