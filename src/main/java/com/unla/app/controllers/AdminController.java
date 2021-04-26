package com.unla.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.app.helpers.ConfigHelper;
import com.unla.app.helpers.RouteHelper;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	 @GetMapping({"dashboard","/"})
	    public ModelAndView index() {
	        ModelAndView view = new ModelAndView(RouteHelper.ADMIN);
	        view.addObject("title", "Inicio - " + ConfigHelper.appName);
	        view.addObject("appName", ConfigHelper.appName);
	        return view;
	    }

}
