package com.ecommerce.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.SearchResult;


@Service
public class SearchService {

	@Autowired
	private ProductService productService;

	//return the serach result 
	public List<SearchResult> searchByName(String categoryName) {
		return productService.findProductByNameContainingIgnoreCase(categoryName).stream().map(SearchResult::new).collect(Collectors.toList());
	}
}
