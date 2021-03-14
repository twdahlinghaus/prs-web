package com.prs.business;

import javax.persistence.*;

@Entity
@Table(name="Products")
public class Product {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String partNumber;
private String name;
private double price;
private String unit;
private String photoPath;
@ManyToOne
@JoinColumn(name="vendorId")
private Vendor vendor;

public Product(int id, String partNumber, String name, double price, String unit, String photoPath, Vendor vendor) {
	super();
	this.id = id;
	this.partNumber = partNumber;
	this.name = name;
	this.price = price;
	this.unit = unit;
	this.photoPath = photoPath;
	this.vendor = vendor;
}

public Product() {
	super();
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getPartNumber() {
	return partNumber;
}

public void setPartNumber(String partNumber) {
	this.partNumber = partNumber;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public String getUnit() {
	return unit;
}

public void setUnit(String unit) {
	this.unit = unit;
}

public String getPhotoPath() {
	return photoPath;
}

public void setPhotoPath(String photoPath) {
	this.photoPath = photoPath;
}

public Vendor getVendor() {
	return vendor;
}

public void setVendor(Vendor vendor) {
	this.vendor = vendor;
}

@Override
public String toString() {
	return "Product [id=" + id + ", partNumber=" + partNumber + ", name=" + name + ", price=" + price + ", unit=" + unit
			+ ", photoPath=" + photoPath + ", vendor=" + vendor + "]";
	}
}
