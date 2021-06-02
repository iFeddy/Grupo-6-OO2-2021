package com.unla.app.controllers;

import java.util.List;

import com.unla.app.entities.Lugares;
import com.unla.app.helpers.ConfigHelper;
import com.unla.app.helpers.RouteHelper;
import com.unla.app.services.ILugarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class PermisosController {
    
    @Autowired
    private ILugarService lugarService;

    @GetMapping({"/permisos", "index", "permisos.index"})
    public ModelAndView index() {       
        ModelAndView view = new ModelAndView(RouteHelper.PERMISOS);
        view.addObject("title", "Solicitar Permiso - " + ConfigHelper.appName);
        view.addObject("appName", ConfigHelper.appName);

        //Agregamos Lugar
        List<Lugares> lugares = lugarService.findAll();
        view.addObject("lugares", lugares);
        return view;
    }   

}
