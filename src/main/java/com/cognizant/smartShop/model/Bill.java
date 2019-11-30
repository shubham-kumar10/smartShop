package com.cognizant.smartShop.model;

import java.util.List;

public class Bill {
	
	private List<Product> productList;
	private List<Integer> quantity;
	private String contact;
	private double total;
	
	
	
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	public List<Integer> getQuantity() {
		return quantity;
	}
	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	}
	public String getContact() {
		return contact;
	}
	@Override
	public String toString() {
		return "Bill [productList=" + productList + ", qauntity=" + quantity + ", contact=" + contact + ", total=" + total
				+ "]";
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
