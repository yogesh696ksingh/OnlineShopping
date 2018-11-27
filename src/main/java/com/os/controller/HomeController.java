package com.os.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.os.dao.HomeDao;
import com.os.model.Category;
import com.os.model.Product;
import com.os.model.User;
@Controller
public class HomeController {
	@Autowired
	HomeDao hdao;
	@RequestMapping(value = "/getCategory/{id}", method=RequestMethod.GET)
	public ModelAndView getCategory(@PathVariable int id) {
		ModelAndView map = new ModelAndView("product");
		List<Category> clist = new LinkedList<Category>();
		clist = hdao.getAllCategory();
		map.addObject("Category",clist);
		List<Product> cplist = new LinkedList<Product>();
		cplist = hdao.getCategoryProducts(id);
		map.addObject("Category_Product",cplist);
		return map;
	}
}
