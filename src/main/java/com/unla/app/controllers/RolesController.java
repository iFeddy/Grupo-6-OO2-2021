package com.unla.app.controllers;

import javax.servlet.http.HttpSession;

import com.unla.app.entities.Users;
import com.unla.app.helpers.AdminSideBarHelper;
import com.unla.app.helpers.AuthHelper;
import com.unla.app.helpers.ConfigHelper;
import com.unla.app.helpers.RouteHelper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class RolesController {
    
    @GetMapping({ "/admin/roles", "roles", "roles" })
	public ModelAndView roles(HttpSession session) {
		ModelAndView view = new ModelAndView(RouteHelper.DASHBOARD_ROLES);
		AdminSideBarHelper sideBar = new AdminSideBarHelper();

		String pageName = "Roles";
		view.addObject("title", pageName + " - " + ConfigHelper.appName);
		view.addObject("pageName", pageName);
		Users user = (Users) session.getAttribute("USER");
		if(user != null){
			view.addObject("userName", user.getFirstName() + " " + user.getLastName());
		}	
		view.addObject("appName", ConfigHelper.appName);

		view.addObject("sideBarLink", 3); // ID del link para que quede en azul (activo) en el menu izquierdo
		view.addObject("sideBar", sideBar.lst_adminSideBar);

		AuthHelper authHelper = new AuthHelper(session);
		return authHelper.AuthMiddleware(view);
	}

}
