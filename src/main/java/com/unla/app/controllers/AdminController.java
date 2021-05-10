package com.unla.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sistema.springboot.app.util.paginator.PageRender;
import com.unla.app.entities.User;
import com.unla.app.helpers.AdminSideBarHelper;
import com.unla.app.helpers.ConfigHelper;
import com.unla.app.helpers.RouteHelper;

import com.unla.app.services.IUserService;

@Controller
@SessionAttributes("user")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private IUserService usuarioService;

	@GetMapping({ "dashboard", "/" })
	public ModelAndView index() {
		ModelAndView view = new ModelAndView(RouteHelper.DASHBOARD);
		AdminSideBarHelper sideBar = new AdminSideBarHelper();

		String pageName = "Panel de Administración";
		view.addObject("title", pageName + " - " + ConfigHelper.appName);
		view.addObject("pageName", pageName);
		view.addObject("userName", "Administrador"); //Reemplazar con Objeto despues de cargar el user desde la DB
		view.addObject("appName", ConfigHelper.appName);
		
		view.addObject("sideBarLink", 1); //ID del link
		view.addObject("sideBar", sideBar.lst_adminSideBar);

		return view;
	}
	
	@GetMapping({ "roles", "/" })// Listar Roles
	public ModelAndView roles() {
		ModelAndView view = new ModelAndView(RouteHelper.DASHBOARD_ROLES);
		AdminSideBarHelper sideBar = new AdminSideBarHelper();

		String pageName = "Roles";
		view.addObject("title", pageName + " - " + ConfigHelper.appName);
		view.addObject("pageName", pageName);
		view.addObject("userName", "Administrador"); //Reemplazar con Objeto despues de cargar el user desde la DB
		view.addObject("appName", ConfigHelper.appName);

		view.addObject("sideBarLink", 3); //ID del link para que quede en azul (activo) en el menu izquierdo
		view.addObject("sideBar", sideBar.lst_adminSideBar);

		return view;
	}

	@GetMapping({ "users", "/" })// LISTAR USUARIO
	public ModelAndView users(@RequestParam(name = "page",defaultValue = "0") int page, Model model) {
		ModelAndView view = new ModelAndView(RouteHelper.DASHBOARD_USERS);
		AdminSideBarHelper sideBar = new AdminSideBarHelper();

		String pageName = "Usuarios";
		view.addObject("title", pageName + " - " + ConfigHelper.appName);
		view.addObject("pageName", pageName);
		view.addObject("userName", "Administrador"); //Reemplazar con Objeto despues de cargar el user desde la DB
		view.addObject("appName", ConfigHelper.appName);

		view.addObject("sideBarLink", 2); //ID del link para que quede en azul (activo) en el menu izquierdo
		view.addObject("sideBar", sideBar.lst_adminSideBar);
		
		// Paginacion 
		Pageable pageRequest = PageRequest.of(page, 4); // cantidad de registros por pagina.
		Page <User> users = usuarioService.findAll(pageRequest); 
		PageRender<User> pageRender = new PageRender<>("users", users);
		model.addAttribute("users",users);
		model.addAttribute("page",pageRender);

		return view;
	}
	
	@RequestMapping("users_add")     // CREAR USUARIO
	public ModelAndView newusers(Model model) {
		ModelAndView view = new ModelAndView(RouteHelper.DASHBOARD_NEW_USERS);
		AdminSideBarHelper sideBar = new AdminSideBarHelper();

		String pageName = "Nuevo Usuario";
		view.addObject("title", pageName + " - " + ConfigHelper.appName);
		view.addObject("pageName", pageName);
		view.addObject("userName", "Administrador"); //Reemplazar con Objeto despues de cargar el user desde la DB
		view.addObject("appName", ConfigHelper.appName);

		view.addObject("sideBarLink", 2); //ID del link para que quede en azul (activo) en el menu izquierdo
		view.addObject("sideBar", sideBar.lst_adminSideBar);
		
		User user = new User();
		model.addAttribute("user", user);
			
		return view;
	}	
	
	
	@RequestMapping(value = "users_save", method = RequestMethod.POST)    // GUARDAR USUARIO
	public String crear( @Valid User user, BindingResult result, Model model,RedirectAttributes flash,SessionStatus status) {	
		ModelAndView view = new ModelAndView(RouteHelper.DASHBOARD_NEW_USERS);
		AdminSideBarHelper sideBar = new AdminSideBarHelper();

		String pageName = "Nuevo Usuario";
		view.addObject("title", pageName + " - " + ConfigHelper.appName);
		view.addObject("pageName", pageName);
		view.addObject("userName", "Administrador"); //Reemplazar con Objeto despues de cargar el user desde la DB
		view.addObject("appName", ConfigHelper.appName);

		view.addObject("sideBarLink", 2); //ID del link para que quede en azul (activo) en el menu izquierdo
		view.addObject("sideBar", sideBar.lst_adminSideBar);
		
		if(result.hasErrors()) {
			return"admin/users_add";
		}
		String mensajeflash= (user.getId()!=null)? "Cliente editado con exito!" :"Cliente creado con exito!";
		user.setActivo(true);
		usuarioService.save(user);
		status.setComplete();
		flash.addFlashAttribute("succes", mensajeflash);
		return"redirect:users";
	}	
	
	@RequestMapping(value = "users_add/{id}") // EDITAR USUARIO
	public ModelAndView editar(@PathVariable(value = "id") Long id ,Map<String,Object> model , RedirectAttributes flash) {
		User user = null;
		ModelAndView view = new ModelAndView(RouteHelper.DASHBOARD_NEW_USERS);
		AdminSideBarHelper sideBar = new AdminSideBarHelper();
		
		String pageName = "Editar Usuario";
		view.addObject("title", pageName + " - " + ConfigHelper.appName);
		view.addObject("pageName", pageName);
		view.addObject("userName", "Administrador"); //Reemplazar con Objeto despues de cargar el user desde la DB
		view.addObject("appName", ConfigHelper.appName);
		view.addObject("sideBarLink", 2); //ID del link para que quede en azul (activo) en el menu izquierdo
		view.addObject("sideBar", sideBar.lst_adminSideBar);
		
		if(id>0) {
			user = usuarioService.findOne(id);
			if(user == null) {
				flash.addFlashAttribute("error", "El ID del Usuario no existe en la Base de Datos");
				ModelAndView modelAndView =  new ModelAndView("redirect:users");
				return modelAndView;
			}
		}else{
			flash.addFlashAttribute("error", "El ID del Usuario no puede ser cero!");
			ModelAndView modelAndView =  new ModelAndView("redirect:users");
			return modelAndView;
		}
		model.put("user", user);
		model.put("titulo", "Editar Usuario");
		return view;
	}
	
	@RequestMapping(value = "admin/delete_user/{id}")// ELIMINAR USUARIO
	public String eliminar(@PathVariable(value ="id") Long id , RedirectAttributes flash) {
		if(id > 0) {
			usuarioService.delete(id);
			flash.addFlashAttribute("succes", "Cliente eliminado con exito!");
		}
		return "redirect:users";
	}
	
	
	
}



