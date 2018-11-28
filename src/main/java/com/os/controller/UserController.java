package com.os.controller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.os.dao.HomeDao;
import com.os.dao.UserDao;
import com.os.model.Category;
import com.os.model.Login;
import com.os.model.Product;
import com.os.model.User;

@Controller
public class UserController {

	@Autowired
	UserDao udao;
	
	@Autowired
	HomeDao hdao;
	
	@RequestMapping("/redirectTest")
	public ModelAndView redirectTest() {
		return new ModelAndView("test");
	}

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
	public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Login l, Model model) {
		boolean log = udao.validateUser(l);
		if(log) {
			List<User> lst = new LinkedList<User>();
			lst = udao.getAllUsers();
			for(User r:lst) {
				if(r.getGu_email().equalsIgnoreCase(l.getGu_email())) {
					List<Category> clist = new LinkedList<Category>();
					List<Product> plist = new LinkedList<Product>();
					clist = hdao.getAllCategory();
					plist = hdao.getLatestProducts();
					ModelAndView map = new ModelAndView("display");
					map.addObject("Category",clist);
					map.addObject("Product", plist);
					return map;
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
