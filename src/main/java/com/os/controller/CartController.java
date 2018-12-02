package com.os.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.os.dao.CartDao;
import com.os.dao.HomeDao;
import com.os.dao.UserDao;
import com.os.model.BillingDetails;
import com.os.model.CartProducts;
import com.os.model.Category;
import com.os.model.Product;


@Controller

public class CartController {

	@Autowired
	CartDao cdao;

	@Autowired
	HomeDao hdao;

	@RequestMapping(value = "/addCartData/{pid}", method=RequestMethod.GET)
	public ModelAndView addcart(@PathVariable long pid,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		CartProducts cp = new CartProducts();
		long user_id = (Long)session.getAttribute("user_id");
		cp.setGp_id(pid);
		int quant = cdao.getProductQuantity(pid, user_id);
		cp.setGc_quantity(quant);
		cp.setGu_id(user_id);
		double price = cdao.getPrice(pid);
		cp.setGp_price(price);
		if(quant == 1) {
			int i = cdao.saveCart(cp);
		}
		else {
			double nprice = price * quant;
			cp.setGp_price(nprice);
			int i = cdao.updateCart(cp, quant);
		}
		List<CartProducts> list = new LinkedList<CartProducts>();
		List<Category> clist = new LinkedList<Category>();
		clist = hdao.getAllCategory();
		list = cdao.getCartData(user_id);
		double total_price = cdao.getTotalPrice(user_id);
		ModelAndView map = new ModelAndView();
		if(list.isEmpty()) {
			map.setViewName("emptyCart");
		}
		else {
			map.setViewName("cart");
			map.addObject("Category",clist);
			map.addObject("cartdata",list);
			map.addObject("total_price", total_price);
		}
		return map;
	}

	@RequestMapping(value = "/myCart/{id}", method=RequestMethod.GET)
	public ModelAndView displayCart(@PathVariable int id,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		long user_id = (Long)session.getAttribute("user_id");
		List<CartProducts> list = new LinkedList<CartProducts>();
		List<Category> clist = new LinkedList<Category>();
		clist = hdao.getAllCategory();
		list = cdao.getCartData(user_id);
		double total_price = cdao.getTotalPrice(user_id);
		ModelAndView map = new ModelAndView();
		if(list.isEmpty()) {
			map.setViewName("emptyCart");
		}
		else {
			map.setViewName("cart");
			map.addObject("Category",clist);
			map.addObject("cartdata",list);
			map.addObject("total_price", total_price);
		}
		return map;
	}
	
	@RequestMapping(value="/billing", method=RequestMethod.GET)
	public ModelAndView billingData(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		long user_id = (Long)session.getAttribute("user_id");
		List<CartProducts> list = new LinkedList<CartProducts>();
		list = cdao.getCartData(user_id);
		int i = cdao.saveBillData(list, user_id);
		ModelAndView map = new ModelAndView("billing");
		if(i>0) {
			List<BillingDetails> blist = new LinkedList<BillingDetails>();
			blist = cdao.getBillingData(user_id);
			map.addObject("billing", blist);
			
		}
		return map;
	}
	
	@RequestMapping(value="/remove/{id}", method=RequestMethod.GET)
	public ModelAndView removeCart(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		long user_id = (Long)session.getAttribute("user_id");
		int i = cdao.removeCartData(id, user_id);
		List<CartProducts> list = new LinkedList<CartProducts>();
		List<Category> clist = new LinkedList<Category>();
		clist = hdao.getAllCategory();
		list = cdao.getCartData(user_id);
		double total_price = cdao.getTotalPrice(user_id);
		ModelAndView map = new ModelAndView();
		if(list.isEmpty()) {
			map.setViewName("emptyCart");
		}
		else {
			map.setViewName("cart");
			map.addObject("Category",clist);
			map.addObject("cartdata",list);
			map.addObject("total_price", total_price);
		}
		return map;
	}
	
	@RequestMapping(value="/add/{id}", method=RequestMethod.GET)
	public ModelAndView addCart(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		long user_id = (Long)session.getAttribute("user_id");
		int i = cdao.addCartData(id, user_id);
		List<CartProducts> list = new LinkedList<CartProducts>();
		List<Category> clist = new LinkedList<Category>();
		clist = hdao.getAllCategory();
		list = cdao.getCartData(user_id);
		double total_price = cdao.getTotalPrice(user_id);
		ModelAndView map = new ModelAndView();
		if(list.isEmpty()) {
			map.setViewName("emptyCart");
		}
		else {
			map.setViewName("cart");
			map.addObject("Category",clist);
			map.addObject("cartdata",list);
			map.addObject("total_price", total_price);
		}
		return map;
	}
	
	@RequestMapping(value="/deduce/{id}", method=RequestMethod.GET)
	public ModelAndView deduceCart(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		long user_id = (Long)session.getAttribute("user_id");
		int i = cdao.deduceCartData(id, user_id);
		List<CartProducts> list = new LinkedList<CartProducts>();
		List<Category> clist = new LinkedList<Category>();
		clist = hdao.getAllCategory();
		list = cdao.getCartData(user_id);
		double total_price = cdao.getTotalPrice(user_id);
		ModelAndView map = new ModelAndView();
		if(list.isEmpty()) {
			map.setViewName("emptyCart");
		}
		else {
			map.setViewName("cart");
			map.addObject("Category",clist);
			map.addObject("cartdata",list);
			map.addObject("total_price", total_price);
		}
		return map;
	}
	
	
}
