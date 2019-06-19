package com.ecommerce.respository.entities;

import java.util.Date;

public class Product implements Comparable<Product> {

	private long id;

	private String name;

	private double purchasePrice;

	private int salePrice;

	private long brandId;

	private long quantity;

	private String description;

	private int available;

	private boolean isPublished;

	private Date added;
	
	private String url;

	public Product(long id, String name, double purchasePrice, int salePrice, long brandId, long quantity,
			String description, int available, boolean isPublished, Date added,String url) {
		this.id = id;
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.brandId = brandId;
		this.quantity = quantity;
		this.description = description;
		this.available = available;
		this.isPublished = isPublished;
		this.added = added;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}

	public Product() {
		if (added == null) {
			added = new Date();
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	public long getBrandId() {
		return brandId;
	}

	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}


	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}


	public boolean isPublished() {
		return isPublished;
	}

	public void setIsPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}

	public void safeCopyFrom(Product other) {
		if (other.id != 0) {
			this.id = other.id;
		}
		if (other.quantity != 0) {
			this.quantity = other.quantity;
		}

		if (other.brandId != 0) {
			this.brandId = other.brandId;
		}

		if (other.description != null) {
			this.description = other.description;
		}

		if (other.name != null) {
			this.name = other.name;
		}

		if (other.purchasePrice != 0) {
			this.purchasePrice = other.purchasePrice;
		}

		if (other.salePrice != 0) {
			this.salePrice = other.salePrice;
		}


	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", purchasePrice=" + purchasePrice + ", salePrice=" + salePrice
				+ ", brandId=" + brandId + ", quantity=" + quantity
				+ ", description=" + description + ", " + ", available=" + available +  "]";
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public Date getAdded() {
		return added;
	}

	@Override
	public int compareTo(Product o) {
		return this.name.compareTo(o.getName());
	}

}
