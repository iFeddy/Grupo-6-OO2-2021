package com.unla.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.app.entities.Lugares;
import com.unla.app.services.ILugarService;


@RestController
@RequestMapping("/permisos/")
public class LugaresController {
	
	@Autowired
    private ILugarService lugarService;

    @PostMapping({ "lugares/create", "index", "permisos.index" })
    public Lugares store(@Valid Lugares lugar, BindingResult result, Model model) {
        // Falta Validar persona
        Lugares existeLugar = null;
        existeLugar = lugarService.findByCodigoPostal(lugar.getCodigoPostal());
        if (existeLugar != null) {
            // Si ya existe la persona con el Mismo DNI (Levanta ese ID)
            lugar = existeLugar;
        }

        // Guarda la Persona
        lugarService.save(lugar);
        
        // Devuelve en JSON la Persona
        return lugar;
    }


}
