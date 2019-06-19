package com.ecommerce.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.respository.entities.ArrayQueue;
import com.ecommerce.respository.entities.Product;
import com.ecommerce.services.ProductService;

@Controller
public class SortingController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/sorting_name")
	public ModelAndView sortingByName(ModelAndView modelAndView) {

		ArrayList<Product> products = productService.getAllProducts();

		Collections.sort((List<Product>) products);
		modelAndView.getModel().put("products", products);
		modelAndView.getModel().put("cart", new Product());
		modelAndView.setViewName("page.index");
		return modelAndView;

	}

	@RequestMapping("/sorting_recurssion")
	public ModelAndView sortingUsingRecurrsion(ModelAndView modelAndView) {

		ArrayList<Product> products = productService.getAllProducts();
		insertionSortRecursive(products, products.size());

		modelAndView.getModel().put("products", products);
		modelAndView.getModel().put("cart", new Product());
		modelAndView.setViewName("page.index");
		return modelAndView;

	}

	// Recursive function to sort an array using
	// insertion sort
	private void insertionSortRecursive(ArrayList<Product> arr, int n) {
		// Base case
		if (n <= 1)
			return;

		// Sort first n-1 elements
		insertionSortRecursive(arr, n - 1);

		// Insert last element at its correct position
		// in sorted array.
		Product last = arr.get(n - 1);
		int j = n - 2;

		/*
		 * Move elements of arr[0..i-1], that are greater than key, to one position
		 * ahead of their current position
		 */
		while (j >= 0 && arr.get(j).getSalePrice() > last.getSalePrice()) {
			arr.set(j + 1, arr.get(j));
			j--;
		}
		arr.set(j + 1, last);
	}

	@RequestMapping("/sorting_queue")
	public ModelAndView sortingTree(ModelAndView modelAndView) {

		ArrayList<Product> products = productService.getAllProducts();
		ArrayQueue queue = new ArrayQueue(products.size());
		for(Product product : products) {
			queue.insert(product);
		}
		List<Product>queueProductsList =Arrays.asList(queue.getQueue());
		
		modelAndView.getModel().put("products", queueProductsList);
		modelAndView.getModel().put("cart", new Product());
		modelAndView.setViewName("page.index");
		return modelAndView;

	}

}
