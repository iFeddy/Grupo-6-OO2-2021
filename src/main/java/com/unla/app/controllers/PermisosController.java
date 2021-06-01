package com.unla.app.controllers;

import com.unla.app.helpers.ConfigHelper;
import com.unla.app.helpers.RouteHelper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class PermisosController {
    
    @GetMapping({"/permisos", "index", "permisos.index"})
    public ModelAndView index() {       
        ModelAndView view = new ModelAndView(RouteHelper.PERMISOS);
        view.addObject("title", "Solicitar Permiso - " + ConfigHelper.appName);
        view.addObject("appName", ConfigHelper.appName);
        return view;
    }   

}
