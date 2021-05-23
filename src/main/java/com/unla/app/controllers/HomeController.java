package com.unla.app.controllers;

import javax.servlet.http.HttpSession;

import com.unla.app.entities.Users;
import com.unla.app.helpers.ConfigHelper;
import com.unla.app.helpers.RouteHelper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping({"/", "index" , "home"})
    public ModelAndView index(HttpSession session) {
        Users user = (Users) session.getAttribute("USER");
        
        ModelAndView view = new ModelAndView(RouteHelper.INDEX);
        view.addObject("title", "Inicio - " + ConfigHelper.appName);
        view.addObject("appName", ConfigHelper.appName);
        view.addObject("user", user);
        return view;
    }   
    
}
