package com.ecommerce.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ecommerce.respository.entities.Product;

@Service
public class CartService {

	private ArrayList<Product> shoppingCart = new ArrayList<Product>();
	public CartService() {
		
	}

	//save product into cart
	public void save(Product product) {
		shoppingCart.add(product);
	}

	//return list shopingcart list
	public ArrayList<Product> getAllShoppingCartItem() {
		return shoppingCart;
	}

	//remove product from list
	public void remove(Product product) {
		shoppingCart.remove(product);
	}

	//get shopping cart using cart id
	public Product getCartShoppingCart(long id) {
		Product p = null;
		//loop throw all shopping cart
		for (Product product : shoppingCart) {
			//check each cart it with an id given by user to remove
			//if id match 
			if (product.getId() == id) {
				p = product;
				//remove the cart from list
				shoppingCart.remove(product);
			}
		}
		return p;
	}

}
