/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.calvin.login.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calvin.login.example.dao.PersonRepository;
import com.calvin.login.example.model.PersonEntity;

@Service
public class LoginServiceImpl{

    @Autowired 
    private PersonRepository personDao;

    public boolean doLogin(String username, String password) {
        PersonEntity person = personDao.findByUsername(username);
        if(person == null) return false;

        if(!person.getPassword().equals(password)) return false;
        else return true;
    }
    
    public boolean createPerson(String username, String password) {
        PersonEntity person = new PersonEntity();
        person.setUsername(username);
        person.setPassword(password);
        personDao.save(person);
        return true;
    }

}
