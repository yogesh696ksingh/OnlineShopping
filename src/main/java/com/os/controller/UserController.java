package com.os.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.os.dao.UserDao;
import com.os.model.Login;
import com.os.model.User;

@Controller
public class UserController {

	@Autowired
	UserDao udao;

	@RequestMapping("/saveUser")
	public ModelAndView helloWorld(HttpServletRequest request, HttpServletResponse response, @ModelAttribute User u) {

		System.out.println("object");

		int i=udao.saveData(u);
		System.out.println("database!");

		if(i>0) {
			System.out.println("success!");
		}
		else
			System.out.println("epic fail!");

		return new ModelAndView("login");
	}

	@RequestMapping("/userLogin")
	public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Login l) {
		boolean log = udao.validateUser(l);
		if(log) {
			List<User> lst = new LinkedList<User>();
			lst = udao.getAllUsers();
			for(User r:lst) {
				if(r.getGu_email().equalsIgnoreCase(l.getGu_email())) {
					return new ModelAndView("display");
				}
			}
		}
		return new ModelAndView("login");
	}
	
	@RequestMapping("/redirectLogin")
	public ModelAndView returnLogin() {
		return new ModelAndView("login");
	}

}
