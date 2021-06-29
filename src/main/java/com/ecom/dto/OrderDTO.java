package com.ecom.dto;

import java.util.Date;
import java.util.List;

import com.ecom.enums.OrderStatus;
import com.ecom.enums.PaymentStatus;

public class OrderDTO {
	
	private Date orderDate;
	private double orderTotalPrice;
	private OrderStatus orderStatus;
	private PaymentStatus paymentStatus;
	
	List<OrderItemDTO> orderItems;

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public List<OrderItemDTO> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemDTO> orderItems) {
		this.orderItems = orderItems;
	}
	
	public OrderDTO() {}

	public OrderDTO(Date orderDate, double orderTotalPrice, OrderStatus orderStatus, PaymentStatus paymentStatus,
			List<OrderItemDTO> orderItems) {
		super();
		this.orderDate = orderDate;
		this.orderTotalPrice = orderTotalPrice;
		this.orderStatus = orderStatus;
		this.paymentStatus = paymentStatus;
		this.orderItems = orderItems;
	}

}
