package com.calvin.login.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calvin.login.example.dao.PersonRepository;
import com.calvin.login.example.model.PersonEntity;

@Service
public class PersonServiceImpl {

    @Autowired 
    PersonRepository personDao;

    public void saveUser(PersonEntity personEntity) {
    	personDao.save(personEntity);
    }

}
