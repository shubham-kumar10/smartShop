package com.cognizant.smartShop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pr_details")
public class PurchaseDetails {
	
	@Id
	@Column(name="pr_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name="pr_code")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="pr_pur_id")
	private Purchase purchase;
	
	@Column(name="pr_quantity")
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public PurchaseDetails() {
	}

	@Override
	public String toString() {
		return "PurchaseDetails [id=" + id + ", product=" + product + ", purchase=" + purchase + ", quantity="
				+ quantity + "]";
	}

	public PurchaseDetails(Product product, Purchase purchase, int quantity) {
		this.product = product;
		this.purchase = purchase;
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((purchase == null) ? 0 : purchase.hashCode());
		result = prime * result + quantity;
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
		PurchaseDetails other = (PurchaseDetails) obj;
		if (id != other.id)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (purchase == null) {
			if (other.purchase != null)
				return false;
		} else if (!purchase.equals(other.purchase))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
	
	
}