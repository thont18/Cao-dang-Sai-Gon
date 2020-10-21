package com.project.springboot.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "fish")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 200, nullable = false)
	private String proCode;
	@Column(length = 200)
	private String name;
	@Column(columnDefinition = "TEXT")
	private String image;
	@Column(length = 10)
	private double price;
	@Column(columnDefinition = "TEXT")
	private String description;
	@CreatedDate
	private LocalDateTime dateCreated;
	@LastModifiedDate
	private LocalDateTime dateModified;
	@CreatedBy
	private String createdBy;
	@LastModifiedBy
	private String modifiedBy;
	@ManyToOne
	@JoinColumn
	private ProductType productType;

	public Product(Integer id, String proCode, String name, String image, int price, String color, String description,
			String amount, LocalDateTime date) {
		this.id = id;
		this.proCode = proCode;
		this.name = name;
		this.image = image;
		this.price = price;
		this.description = description;
	}

	public Product(Integer id, String proCode, String name, String image, double price, String description,
			LocalDateTime dateCreated, LocalDateTime dateModified, String createdBy, String modifiedBy,
			ProductType productType) {
		super();
		this.id = id;
		this.proCode = proCode;
		this.name = name;
		this.image = image;
		this.price = price;
		this.description = description;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.productType = productType;
	}

	public Product() {
		super();
	}

	public Product(String proCode, String name, String image, double price, String description,
			LocalDateTime dateCreated, LocalDateTime dateModified, String createdBy, String modifiedBy,
			ProductType productType) {
		super();
		this.proCode = proCode;
		this.name = name;
		this.image = image;
		this.price = price;
		this.description = description;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.productType = productType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LocalDateTime getDateModified() {
		return dateModified;
	}

	public void setDateModified(LocalDateTime dateModified) {
		this.dateModified = dateModified;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
}
