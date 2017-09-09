package com.calvin.login.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.calvin.login.example.model.ProductPersonEntity;
import com.calvin.login.example.service.LoginServiceImpl;
import com.calvin.login.example.service.ProductPersonServiceImpl;

@Controller
public class MainController {

    @Autowired 
    private LoginServiceImpl loginServiceImpl;
    
    @Autowired 
    private ProductPersonServiceImpl productPersonServiceImpl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginPage(Model model ) {
        return "/login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String doLogin(
            ModelMap model,
            String username,
            String password) {

        boolean success = loginServiceImpl.doLogin(username, password);

        if(success) {
        	List<ProductPersonEntity> products = productPersonServiceImpl.getAllProductWithUsername(username);
        	model.addAttribute("products", products);
            return "/main";
        } else {
        	loginServiceImpl.createPerson(username, password);
            return "/main";
        }
    }
}
