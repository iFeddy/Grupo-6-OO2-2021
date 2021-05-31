package com.unla.app.controllers;

import com.unla.app.entities.Users;
import com.unla.app.helpers.ConfigHelper;
import com.unla.app.helpers.RouteHelper;
import com.unla.app.services.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//Session
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {


}
