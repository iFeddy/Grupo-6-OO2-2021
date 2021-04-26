package com.unla.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.app.helpers.AdminSideBarHelper;
import com.unla.app.helpers.ConfigHelper;
import com.unla.app.helpers.RouteHelper;

@Controller
@RequestMapping("/admin")
public class AdminController {

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

	@GetMapping({ "users", "/" })
	public ModelAndView users() {
		ModelAndView view = new ModelAndView(RouteHelper.DASHBOARD_USERS);
		AdminSideBarHelper sideBar = new AdminSideBarHelper();

		String pageName = "Usuarios";
		view.addObject("title", pageName + " - " + ConfigHelper.appName);
		view.addObject("pageName", pageName);
		view.addObject("userName", "Administrador"); //Reemplazar con Objeto despues de cargar el user desde la DB
		view.addObject("appName", ConfigHelper.appName);

		view.addObject("sideBarLink", 2); //ID del link para que quede en azul (activo) en el menu izquierdo
		view.addObject("sideBar", sideBar.lst_adminSideBar);

		return view;
	}
}
