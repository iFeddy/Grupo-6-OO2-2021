package com.unla.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.unla.app.helpers.AdminSideBarHelper;
import com.unla.app.helpers.ConfigHelper;
import com.unla.app.helpers.RouteHelper;

@Controller
@RequestMapping("/")
public class AdminController {

	
	@GetMapping({ "/admin", "admin", "admin.index" })
	public String admin() {
		return "redirect:/admin/dashboard";	
	}

	@GetMapping({ "/admin/dashboard", "index", "dashboard" })
	public ModelAndView index() {
		ModelAndView view = new ModelAndView(RouteHelper.DASHBOARD);
		AdminSideBarHelper sideBar = new AdminSideBarHelper();

		String pageName = "Panel de Administración";
		view.addObject("title", pageName + " - " + ConfigHelper.appName);
		view.addObject("pageName", pageName);	
		view.addObject("appName", ConfigHelper.appName);

		view.addObject("sideBarLink", 1); // ID del link
		view.addObject("sideBar", sideBar.lst_adminSideBar);
		return view;		
	
	}

}
