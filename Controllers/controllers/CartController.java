package com.ecommerce.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.respository.entities.Product;
import com.ecommerce.services.CartService;
import com.ecommerce.services.ProductService;
import com.ecommerce.status.Status;

@Controller
public class CartController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CartService cartService;
	
	
	// when a user go the url /addtocart/{id} for example /addtocart/5
	@RequestMapping("/addtocart/{id}")
	private ResponseEntity<Status> addToCart(ModelAndView modelAndView, HttpServletRequest request,
			@PathVariable(name = "id") long productId) {
		
		//get the id from url and pass it to get product which has the id passed in url
		Product product= productService.getProduct(productId);
		
		//set status by default to failed to add prodcut
		Status status = new Status("Failed to add product");
		
		//if retreived product is not null 
		if(product !=null) {
			
			//save the product into cart 
			cartService.save(product);
			//change status to product successfuly added
			status = new Status("Product successfully added");
		}
		
		//return status
		return new ResponseEntity(status,HttpStatus.OK);
	}

	///when a user go the url /cart
	@RequestMapping("/cart")
	public ModelAndView cart(ModelAndView modelAndView) {
	
		//then get all the items from ShoppingCart and store into into ArrayList<Product> cart 
		ArrayList<Product> cart = cartService.getAllShoppingCartItem();
		
		//pass he carts into front cart.jsp page
		modelAndView.getModel().put("carts", cart);
		
		//set view name cart which mean the user will go the cart page
		modelAndView.setViewName("page.cart");
		return modelAndView;
	}
	
	///when a user go the /removecartitem/product id for example /removecartitem/1  , 1 is path variable
	@RequestMapping("/removecartitem/{id}")
	@ResponseBody
	public ResponseEntity<Status> removeCartItem(ModelAndView modelAndView  , @PathVariable(name="id") long id){
		//pass path variable to getProduct using id
		Product product = productService.getProduct(id);
		//remove that product which has id passed in url
		cartService.remove(product);
		//set status to product successfully removed
		Status status  = new Status("Product is been successfully remove from cart");
		return new ResponseEntity(status,HttpStatus.OK);
	}
	
}
