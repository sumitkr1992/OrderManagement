package com.ecom.dto;


public class OrderItemDTO {
	private int itemQuantity;
	private double itemPrice;
	private int product_id;
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	public OrderItemDTO() {}
	
	public OrderItemDTO(int itemQuantity, double itemPrice, int product_id) {
		super();
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
		this.product_id = product_id;
	}
}
