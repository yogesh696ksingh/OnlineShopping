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
import com.os.dao.UserDao;
import com.os.model.CartProducts;
import com.os.model.Product;


@Controller

public class CartController {

	@Autowired
	CartDao cdao;

	@RequestMapping(value = "/addCartData/{pid}", method=RequestMethod.GET)
	public ModelAndView addcart(@PathVariable long pid,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		CartProducts cp = new CartProducts();
		cp.setGp_id(pid);
		int quant = cdao.getProductQuantity(pid);
		cp.setGc_quantity(quant);
		long user_id = (Long)session.getAttribute("user_id");
		cp.setGu_id(user_id);
		int i = cdao.saveCart(cp);
		List<CartProducts> list = new LinkedList<CartProducts>();
		list = cdao.getCartData(user_id);
		ModelAndView map = new ModelAndView("cart");
		map.addObject("cartdata",list);
		return map;	

	}
}
