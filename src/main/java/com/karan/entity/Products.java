package com.karan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String productname;
	private String description;
	private String price;
	private String quantity;
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(String productname, String description, String price, String quantity) {
		super();
		this.productname = productname;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", productname=" + productname + ", description=" + description + ", price="
				+ price + ", quantity=" + quantity + "]";
	}
	
}
