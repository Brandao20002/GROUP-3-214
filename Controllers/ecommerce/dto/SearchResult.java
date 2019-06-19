package com.ecommerce.dto;

import com.ecommerce.respository.entities.Product;

public class SearchResult {
	private Long productId;
	private String name;
	private String description;
	private long quantity;
	private int salePrice;
	private double purchasePrice;
	private String url;
	
	
	public SearchResult() {
		
	}
	
	public SearchResult(Product product) {
		productId = product.getId();
		name = product.getName();
		description = product.getDescription();
		quantity = product.getQuantity();
		 salePrice = product.getSalePrice();
		purchasePrice= product.getPurchasePrice();
		this.url = product.getUrl();
	}
	
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	@Override
	public String toString() {
		return "SearchResult [productId=" + productId + ", name=" + name + ", description=" + description
				+ ", quantity=" + quantity + ", salePrice=" + salePrice + ", purchasePrice=" + purchasePrice + "]";
	}
	
	
}
