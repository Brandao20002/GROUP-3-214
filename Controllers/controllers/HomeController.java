package com.ecommerce.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.respository.entities.Product;
import com.ecommerce.services.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	//when a user go the / url its mean localhost:8080
	@RequestMapping("/")
	public ModelAndView showHome(ModelAndView modelAndView, HttpSession session) {

		//get all product and pass it to index.jsp
		ArrayList<Product> products = productService.getAllProducts();
		modelAndView.getModel().put("products", products);
		
		//set viewname to index page 
		modelAndView.setViewName("page.index");
		//go to view page
		return modelAndView;

	}

	//when user go the url /prodcut/product id , for example /product/10 , 10 is product id
	@RequestMapping("/product/{id}")
	public ModelAndView showHome(ModelAndView modelAndView, HttpSession session,@PathVariable(name="id") int id) {

		//pass the pathvariable id to getProduct and store into product
		Product product = productService.getProduct(id);

		//pass the product into proruct.jsp page
		modelAndView.getModel().put("product", product);
		//send emapty cart into product.jsp
		modelAndView.getModel().put("cart", new Product());
		
		//set view name to product.jsp
		modelAndView.setViewName("page.product");
		return modelAndView;

	}

	

}
