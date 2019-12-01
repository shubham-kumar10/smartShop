package com.cognizant.smartShop.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="purchase")
public class Purchase {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private USER user;
	
	@Column(name="total")
	private int total;
	
	@Column(name="rewards")
	private int rewardPoints;
	
	@Column(name="date")
	private Date dateOfPurchase;
	
	@OneToMany(mappedBy="purchase")
	private List<PurchaseDetails> purchaseDetails;

	public void setPurchaseDetails(List<PurchaseDetails> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public USER getUser() {
		return user;
	}

	public void setUser(USER user) {
		this.user = user;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public Purchase(USER user, int total_amount, int reward_points, Date date) {
		this.user = user;
		this.total = total_amount;
		this.rewardPoints = reward_points;
		this.dateOfPurchase = date;
	}

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", user=" + user + ", total=" + total + ", rewardPoints=" + rewardPoints
				+ ", dateOfPurchase=" + dateOfPurchase + ", purchaseDetails=" + purchaseDetails + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfPurchase == null) ? 0 : dateOfPurchase.hashCode());
		result = prime * result + id;
		result = prime * result + ((purchaseDetails == null) ? 0 : purchaseDetails.hashCode());
		result = prime * result + rewardPoints;
		result = prime * result + total;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Purchase other = (Purchase) obj;
		if (dateOfPurchase == null) {
			if (other.dateOfPurchase != null)
				return false;
		} else if (!dateOfPurchase.equals(other.dateOfPurchase))
			return false;
		if (id != other.id)
			return false;
		if (purchaseDetails == null) {
			if (other.purchaseDetails != null)
				return false;
		} else if (!purchaseDetails.equals(other.purchaseDetails))
			return false;
		if (rewardPoints != other.rewardPoints)
			return false;
		if (total != other.total)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
}
