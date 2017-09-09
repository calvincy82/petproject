package com.calvin.login.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calvin.login.example.model.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    PersonEntity findByUsername(String username);
}
