package com.calvin.login.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calvin.login.example.dao.PersonRepository;
import com.calvin.login.example.dao.ProductPersonRepository;
import com.calvin.login.example.model.PersonEntity;
import com.calvin.login.example.model.ProductPersonEntity;

@Service
public class ProductPersonServiceImpl {

    @Autowired 
    ProductPersonRepository productPersonDao;

    @Autowired 
    PersonRepository personDao;

    public List<ProductPersonEntity> getAllProductWithUsername(String username) {
    	PersonEntity person = personDao.findByUsername(username);
    	List<ProductPersonEntity> productPersonList = productPersonDao.findByPersonId(person.getId());
    	return productPersonList;
    }

}
