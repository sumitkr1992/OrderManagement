package com.ecom.model;

import lombok.Data;
import javax.persistence.*;
//import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Products")
public @Data class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "prod_name")
	private @NotNull String productName;
	
	@Column(name = "prod_price")
	private @NotNull double productPrice;
	
	@Column(name = "prod_description")
    private @NotNull String productDescription;
	
	@Column(name = "prod_quantity")
    private Integer productAvlQuantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getProductAvlQuantity() {
		return productAvlQuantity;
	}

	public void setProductAvlQuantity(Integer productAvlQuantity) {
		this.productAvlQuantity = productAvlQuantity;
	}
	
	
}
