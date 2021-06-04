package com.unla.app.controllers.REST;

import java.sql.Date;
import java.util.Optional;

import com.unla.app.entities.Lugares;
import com.unla.app.entities.Personas;
import com.unla.app.entities.Rodados;
import com.unla.app.models.PermisoDiarioModel;
import com.unla.app.services.implementation.LugaresServices;
import com.unla.app.services.implementation.PermisosServices;
import com.unla.app.services.implementation.PersonaServices;
import com.unla.app.services.implementation.RodadoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
@RequestMapping("/")
public class PermisosController {
    @Autowired
	@Qualifier("permisosService")
	private PermisosServices permisoService;
    
    @Autowired
	private RodadoServices rodadoService;

	@Autowired
	private LugaresServices lugarService;

	@Autowired
	private PersonaServices personaService;
    
    @RequestMapping(value = "/permisos/create", method = RequestMethod.POST)
    public String store(@RequestBody PermisoDiarioModel permisoModel,
    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {			
			return bindingResult.getFieldErrors().toString();
		}
        permisoModel.setFecha(Date.valueOf(permisoModel.getFechaString()));        
        permisoModel.setDesdeHasta(lugarService.getLugares());
        permisoService.insertOrUpdate(permisoModel);
        //Mostrar mensaje de que se cargo bien
        return permisoModel.toString();
    }


    @RequestMapping(value = "/permisos/temporario/create", method = RequestMethod.POST)
    public String store_temp(@RequestParam(required = true) Personas persona,
            @RequestParam(required = false) Optional<Rodados> rodado, @RequestParam("salida") Optional<Lugares> salida,
            @RequestParam(required = false) Optional<Lugares> destino,
            @RequestParam(required = false) Optional<Integer> permiso_tipo,
            @RequestParam(required = false) Optional<String> permiso_fecha,
            @RequestParam(required = false) Optional<String> motivo_desc,
            @RequestParam(required = false) Optional<Boolean> motivo_vacaciones,
            @RequestParam(required = false) Optional<Integer> motivo_dias,
            RedirectAttributes flash) {

        // Imprimir datos prueba
        System.out.println(persona);
        System.out.println(rodado);
        System.out.println(destino);
        System.out.println(permiso_tipo);
        System.out.println(permiso_fecha);
        System.out.println(motivo_desc);
        System.out.println(motivo_vacaciones);
        System.out.println(motivo_dias);

        /*
         * motivo_desc.getOrElse(null) description.ifPresent(value ->
         * item.setDescription(description)); //funcion si esta presente
         */
        return "hola";
    }



}

