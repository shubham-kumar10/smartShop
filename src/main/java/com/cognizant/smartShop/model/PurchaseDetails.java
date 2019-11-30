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
	
}