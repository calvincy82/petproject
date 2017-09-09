package com.calvin.login.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calvin.login.example.model.ProductPersonEntity;

/**
 * Created on 8/7/2016.
 */
public interface ProductPersonRepository extends JpaRepository<ProductPersonEntity, Long> {
    List<ProductPersonEntity> findByPersonId(long personId);
}
