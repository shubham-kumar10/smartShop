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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((productList == null) ? 0 : productList.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}
	public Bill(String contact,List<Product> productList, List<Integer> quantity,double total) {
		super();
		this.productList = productList;
		this.quantity = quantity;
		this.contact = contact;
		this.total = total;
	}
	
	
}
