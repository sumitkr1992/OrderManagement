package com.ecom.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
//import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;

import com.ecom.enums.OrderStatus;
import com.ecom.enums.PaymentStatus;

@Entity
@Table(name = "Orders")
public @Data class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "order_total_price")
    private double orderTotalPrice;
    
    @Column(name = "order_status")
    private OrderStatus orderStatus;
    
    @Column(name = "order_payment_status")
    private PaymentStatus paymentStatus;
    
    @OneToMany(targetEntity = OrderItem.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_fk", referencedColumnName = "id")
    private List<OrderItem> orderItems;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
    
    

}
