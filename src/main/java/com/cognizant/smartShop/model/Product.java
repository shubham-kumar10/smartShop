package com.cognizant.smartShop.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "Product_Code")
	private String code;
	
	@Column(name = "Product_Name")
	private String name;
	
	@Column(name = "Product_Type")
	private String type;
	
	@Column(name = "Brand")
	private String brand;
	
	@Column(name = "Quantity_type")
	private String quantity_type;
	
	@Column(name = "Rate_per_quantity")
	private String rate_per_quantity;
	
	@Column(name = "Stock_count")
	private String stock_count;
	
	@Column(name = "Add_date")
	private Date add_date;
	
	@Column(name = "Aisle")
	private String aisle;
	
	@Column(name = "Shelf")
	private String shelf;
	
	@Column(name = "Date_of_manufacture")
	private Date date_of_manufacture;
	
	@Column(name = "Date_of_expiry")
	private Date date_of_expiry;
	
	@Column(name = "Product_image")
	private String image;

	public Product() {
	}

	public Product(String code, String name, String type, String brand, String quantity_type, String rate_per_quantity,
			String stock_count, Date add_date, String aisle, String shelf, Date date_of_manufacture, Date date_of_expiry,
			String image) {
		this.code = code;
		this.name = name;
		this.type = type;
		this.brand = brand;
		this.quantity_type = quantity_type;
		this.rate_per_quantity = rate_per_quantity;
		this.stock_count = stock_count;
		this.add_date = add_date;
		this.aisle = aisle;
		this.shelf = shelf;
		this.date_of_manufacture = date_of_manufacture;
		this.date_of_expiry = date_of_expiry;
		this.image = image;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getQuantity_type() {
		return quantity_type;
	}

	public void setQuantity_type(String quantity_type) {
		this.quantity_type = quantity_type;
	}

	public String getRate_per_quantity() {
		return rate_per_quantity;
	}

	public void setRate_per_quantity(String rate_per_quantity) {
		this.rate_per_quantity = rate_per_quantity;
	}

	public String getStock_count() {
		return stock_count;
	}

	public void setStock_count(String stock_count) {
		this.stock_count = stock_count;
	}

	public Date getAdd_date() {
		return add_date;
	}

	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}

	public String getAisle() {
		return aisle;
	}

	public void setAisle(String aisle) {
		this.aisle = aisle;
	}

	public String getShelf() {
		return shelf;
	}

	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	public Date getDate_of_manufacture() {
		return date_of_manufacture;
	}

	public void setDate_of_manufacture(Date date_of_manufacture) {
		this.date_of_manufacture = date_of_manufacture;
	}

	public Date getDate_of_expiry() {
		return date_of_expiry;
	}

	public void setDate_of_expiry(Date date_of_expiry) {
		this.date_of_expiry = date_of_expiry;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", type=" + type + ", brand=" + brand + ", quantity_type="
				+ quantity_type + ", rate_per_quantity=" + rate_per_quantity + ", stock_count=" + stock_count
				+ ", add_date=" + add_date + ", aisle=" + aisle + ", shelf=" + shelf + ", date_of_manufacture="
				+ date_of_manufacture + ", date_of_expiry=" + date_of_expiry + ", image=" + image + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((add_date == null) ? 0 : add_date.hashCode());
		result = prime * result + ((aisle == null) ? 0 : aisle.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((date_of_expiry == null) ? 0 : date_of_expiry.hashCode());
		result = prime * result + ((date_of_manufacture == null) ? 0 : date_of_manufacture.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((quantity_type == null) ? 0 : quantity_type.hashCode());
		result = prime * result + ((rate_per_quantity == null) ? 0 : rate_per_quantity.hashCode());
		result = prime * result + ((shelf == null) ? 0 : shelf.hashCode());
		result = prime * result + ((stock_count == null) ? 0 : stock_count.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Product other = (Product) obj;
		if (add_date == null) {
			if (other.add_date != null)
				return false;
		} else if (!add_date.equals(other.add_date))
			return false;
		if (aisle == null) {
			if (other.aisle != null)
				return false;
		} else if (!aisle.equals(other.aisle))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (date_of_expiry == null) {
			if (other.date_of_expiry != null)
				return false;
		} else if (!date_of_expiry.equals(other.date_of_expiry))
			return false;
		if (date_of_manufacture == null) {
			if (other.date_of_manufacture != null)
				return false;
		} else if (!date_of_manufacture.equals(other.date_of_manufacture))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quantity_type == null) {
			if (other.quantity_type != null)
				return false;
		} else if (!quantity_type.equals(other.quantity_type))
			return false;
		if (rate_per_quantity == null) {
			if (other.rate_per_quantity != null)
				return false;
		} else if (!rate_per_quantity.equals(other.rate_per_quantity))
			return false;
		if (shelf == null) {
			if (other.shelf != null)
				return false;
		} else if (!shelf.equals(other.shelf))
			return false;
		if (stock_count == null) {
			if (other.stock_count != null)
				return false;
		} else if (!stock_count.equals(other.stock_count))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}
