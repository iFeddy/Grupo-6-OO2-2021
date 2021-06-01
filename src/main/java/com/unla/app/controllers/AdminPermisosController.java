package com.unla.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600L)
@RequestMapping("/admin/")
public class AdminPermisosController {
	//@Autowired
	//private IUserService usuarioService;  

	//@Autowired
	//private IUserRoleService userRoleService;

	// GET Listado de Permisos
	/*@GetMapping({ "/permisos", "index", "permisos.index" })
	public ModelAndView index(@RequestParam(name = "page", defaultValue = "0") int page, Model model, HttpSession session){
		return mHelper.AuthMiddleware(mHelper.RoleMiddleware(view, 25, roles));
	}*/

	// POST Guardar Permiso Nuevo
	//@PostMapping({ "/permisos", "store", "permisos.store" })
	/*public String store(@Valid Users user, BindingResult result, Model model, RedirectAttributes flash) {

		return "redirect:/admin/permisos";
	}*/


	// POST Editar Permisos / Guardar edición
	//@PostMapping({ "/permisos/{id}", "update", "permisos.update" })
	/*public String update(@Valid Users user, @PathVariable(value = "id") Long id, BindingResult result, Model model, RedirectAttributes flash, HttpSession session) {
		
		return "redirect:/admin/permisos";
	}*/

	// DELETE Eliminar Permiso
	//@DeleteMapping({ "/permisos/{id}", "destroy", "permisos.destroy" })
	/*public String destroy(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
	
		return "redirect:/admin/permisos";
	}*/

}
