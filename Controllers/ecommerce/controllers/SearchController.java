package com.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.dto.SearchResult;
import com.ecommerce.respository.entities.Product;
import com.ecommerce.services.SearchService;


@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	//when a user click on search 
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public ModelAndView  search(ModelAndView modelAndView , @RequestParam(name="s") String text) {
		
		//pass the value text that you user wanna search and get the match result and store into results
		List<SearchResult> results = searchService.searchByName(text);
		//pass empty cart objec tinto result.jsp
		modelAndView.getModel().put("cart", new Product());
		//pass all result into result.jsp too
		modelAndView.getModel().put("results", results);
		
		modelAndView.setViewName("page.search");
		
		return modelAndView;
	}
	
	
}






