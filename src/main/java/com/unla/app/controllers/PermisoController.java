package com.unla.app.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unla.app.converters.PersonaConverter;
import com.unla.app.converters.RodadoConverter;
import com.unla.app.entities.Personas;
import com.unla.app.entities.Rodados;
import com.unla.app.entities.Users;
import com.unla.app.entities.UsersRole;
import com.unla.app.helpers.AdminSideBarHelper;
import com.unla.app.helpers.ConfigHelper;
import com.unla.app.helpers.MiddlewareHelper;
import com.unla.app.helpers.RouteHelper;
import com.unla.app.models.PermisoDiarioModel;
import com.unla.app.models.PermisoPeriodoModel;
import com.unla.app.models.PersonaModel;
import com.unla.app.models.RodadoModel;
import com.unla.app.services.IPermisoService;
import com.unla.app.services.IPersonaService;
import com.unla.app.services.IRodadoService;
import com.unla.app.services.IUserRoleService;

@Controller
public class PermisoController {

	@Autowired
	@Qualifier("rodadoConverter")
	private RodadoConverter rodadoConverter;

	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;

	@Autowired
	private IPersonaService personaService;

	@Autowired
	private IRodadoService rodadoService;

	@Autowired
	private IPermisoService permisoService;

	@Autowired
	private IUserRoleService userRoleService;

	@GetMapping({ "/admin/permits", "permits", "permits" })
	public ModelAndView permisos(Model model, HttpSession session) {

		ModelAndView view = new ModelAndView(RouteHelper.DASHBOARD_PERMITS);
		AdminSideBarHelper sideBar = new AdminSideBarHelper();

		String pageName = "Buscar Permisos";
		view.addObject("title", pageName + " - " + ConfigHelper.appName);
		view.addObject("pageName", pageName);
		Users user = (Users) session.getAttribute("USER");
		if (user != null) {
			view.addObject("userName", user.getFirstName() + " " + user.getLastName());
		}
		view.addObject("appName", ConfigHelper.appName);

		view.addObject("sideBarLink", 4); // ID del link para que quede en azul (activo) en el menu izquierdo
		view.addObject("sideBar", sideBar.lst_adminSideBar);

		List<UsersRole> roles = userRoleService.findAll();
		MiddlewareHelper mHelper = new MiddlewareHelper(session);
		return mHelper.AuthMiddleware(mHelper.RoleMiddleware(view, 25, roles));
	}

	@GetMapping({ "/admin/permits/rodados", "rodados", "permisos.rodados" })
	public ModelAndView permisosRodados(Model model, HttpSession session) {

		ModelAndView view = new ModelAndView(RouteHelper.DASHBOARD_PERMITS_RODADOS);
		AdminSideBarHelper sideBar = new AdminSideBarHelper();

		String pageName = "Permisos por Rodados";
		view.addObject("title", pageName + " - " + ConfigHelper.appName);
		view.addObject("pageName", pageName);
		Users user = (Users) session.getAttribute("USER");
		if (user != null) {
			view.addObject("userName", user.getFirstName() + " " + user.getLastName());
		}
		view.addObject("appName", ConfigHelper.appName);

		view.addObject("sideBarLink", 4); // ID del link para que quede en azul (activo) en el menu izquierdo
		view.addObject("sideBar", sideBar.lst_adminSideBar);

		List<UsersRole> roles = userRoleService.findAll();
		MiddlewareHelper mHelper = new MiddlewareHelper(session);
		return mHelper.AuthMiddleware(mHelper.RoleMiddleware(view, 25, roles));
	}

	@GetMapping({ "/admin/permits/persona", "persona", "permits.persona" })
	public ModelAndView permisosPersona(Model model, HttpSession session) {

		ModelAndView view = new ModelAndView(RouteHelper.DASHBOARD_PERMITS_PERSONS);
		AdminSideBarHelper sideBar = new AdminSideBarHelper();

		String pageName = "Permisos por Rersona";
		view.addObject("title", pageName + " - " + ConfigHelper.appName);
		view.addObject("pageName", pageName);
		Users user = (Users) session.getAttribute("USER");
		if (user != null) {
			view.addObject("userName", user.getFirstName() + " " + user.getLastName());
		}
		view.addObject("appName", ConfigHelper.appName);

		view.addObject("sideBarLink", 4); // ID del link para que quede en azul (activo) en el menu izquierdo
		view.addObject("sideBar", sideBar.lst_adminSideBar);

		List<UsersRole> roles = userRoleService.findAll();
		MiddlewareHelper mHelper = new MiddlewareHelper(session);
		return mHelper.AuthMiddleware(mHelper.RoleMiddleware(view, 25, roles));
	}

	@GetMapping({ "/admin/permits/fechas", "fechas", "permits.fechas" })
	public ModelAndView permisosFechas(HttpSession session) {

		ModelAndView view = new ModelAndView(RouteHelper.DASHBOARD_PERMITS_DATES);
		AdminSideBarHelper sideBar = new AdminSideBarHelper();

		String pageName = "Permisos por Fechas";
		view.addObject("title", pageName + " - " + ConfigHelper.appName);
		view.addObject("pageName", pageName);
		Users user = (Users) session.getAttribute("USER");
		if (user != null) {
			view.addObject("userName", user.getFirstName() + " " + user.getLastName());
		}
		view.addObject("appName", ConfigHelper.appName);

		view.addObject("sideBarLink", 4); // ID del link para que quede en azul (activo) en el menu izquierdo
		view.addObject("sideBar", sideBar.lst_adminSideBar);

		List<UsersRole> roles = userRoleService.findAll();
		MiddlewareHelper mHelper = new MiddlewareHelper(session);
		return mHelper.AuthMiddleware(mHelper.RoleMiddleware(view, 25, roles));
	}

	@GetMapping({ "/admin/permits/fechas/lugar", "fechaslugar", "permits.fechas.lugar" })
	public ModelAndView permisosFechasLugar(HttpSession session) {

		ModelAndView view = new ModelAndView(RouteHelper.DASHBOARD_PERMITS_DATES_PLACE);
		AdminSideBarHelper sideBar = new AdminSideBarHelper();

		String pageName = "Permisos por Fechas y Lugar";
		view.addObject("title", pageName + " - " + ConfigHelper.appName);
		view.addObject("pageName", pageName);
		Users user = (Users) session.getAttribute("USER");
		if (user != null) {
			view.addObject("userName", user.getFirstName() + " " + user.getLastName());
		}
		view.addObject("appName", ConfigHelper.appName);

		view.addObject("sideBarLink", 4); // ID del link para que quede en azul (activo) en el menu izquierdo
		view.addObject("sideBar", sideBar.lst_adminSideBar);

		List<UsersRole> roles = userRoleService.findAll();
		MiddlewareHelper mHelper = new MiddlewareHelper(session);
		return mHelper.AuthMiddleware(mHelper.RoleMiddleware(view, 25, roles));
	}

	@PostMapping("/admin/permits/rodados")
	public ModelAndView permisosPorRodados(@RequestParam("dominio") String dominio, Model model, HttpSession session,
			RedirectAttributes flash) {

		ModelAndView view = new ModelAndView(RouteHelper.DASHBOARD_PERMITS_RODADOS); //se puede poner en una vista separada
		AdminSideBarHelper sideBar = new AdminSideBarHelper();

		String pageName = "Permisos por Rodados";
		view.addObject("title", pageName + " - " + ConfigHelper.appName);
		view.addObject("pageName", pageName);
		Users user = (Users) session.getAttribute("USER");
		if (user != null) {
			view.addObject("userName", user.getFirstName() + " " + user.getLastName());
		}
		view.addObject("appName", ConfigHelper.appName);

		view.addObject("sideBarLink", 4); // ID del link para que quede en azul (activo) en el menu izquierdo
		view.addObject("sideBar", sideBar.lst_adminSideBar);

		List<UsersRole> roles = userRoleService.findAll();
		MiddlewareHelper mHelper = new MiddlewareHelper(session);

		Rodados rm = rodadoService.findOneByDominio(dominio);
		// Si el dominio no tiene permisos
		if (rm == null) {
			view.addObject("error", "El dominio no se encuentra registrado.");			
			return mHelper.AuthMiddleware(mHelper.RoleMiddleware(view, 25, roles));
		}

		RodadoModel rodadoModel = rodadoConverter.entityToModel(rm);

		List<PermisoPeriodoModel> permisoperiodo = null;
		permisoperiodo = permisoService.findByDominio(rodadoModel);

		// Si el dominio no tiene permisos
		if (permisoperiodo == null) {
			view.addObject("error", "El dominio no se encuentra registrado en un Permiso.");
			return mHelper.AuthMiddleware(mHelper.RoleMiddleware(view, 25, roles));
		}

		// Si encontro registros los agregamos al modelo para mostrar el listado
		view.addObject("permisoperiodo", permisoperiodo);
		view.addObject("success", "Se encontraron " + permisoperiodo.size() + " permisos con el rodado " + rodadoModel.getDominio());
		return mHelper.AuthMiddleware(mHelper.RoleMiddleware(view, 25, roles));		
	}

	@PostMapping("/admin/permits/personas")
	public String permisosPorPersona(@RequestParam("dni") int dni, Model model, HttpSession session,
			RedirectAttributes flash) {
		Personas pp = personaService.findOneByDNI(dni);
		PersonaModel personaModel = personaConverter.entityToModel(pp);

		List<PermisoPeriodoModel> permisoperiodo = null;
		List<PermisoDiarioModel> permisodiario = null;
		permisoperiodo = permisoService.findByPersonaPeriodo(personaModel);
		permisodiario = permisoService.findByPersonaDiario(personaModel);

		model.addAttribute("permisoperiodo", permisoperiodo);
		model.addAttribute("permidodiario", permisodiario);

		// Si el dominio no existe
		if (permisoperiodo == null) {
			flash.addFlashAttribute("message", "La persona no cuenta con un Permiso registrado.");
			return "redirect:/admin/permits/rodados";
		}

		return "/admin/permits";
	}

}