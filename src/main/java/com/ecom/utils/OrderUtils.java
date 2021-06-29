package com.ecom.utils;

import java.util.ArrayList;
import java.util.List;

import com.ecom.dto.OrderDTO;
import com.ecom.dto.OrderItemDTO;
import com.ecom.enums.OrderStatus;
import com.ecom.enums.PaymentStatus;
import com.ecom.model.Order;
import com.ecom.model.OrderItem;

public class OrderUtils {
	
	public static void initializeOrder(OrderDTO orderDTO) {
		orderDTO.setOrderStatus(OrderStatus.PENDING);
		orderDTO.setPaymentStatus(PaymentStatus.PENDING);
	}
	
	public static Order transformToOrder(OrderDTO orderDTO) {
		Order order = new Order();
		
		order.setOrderDate(orderDTO.getOrderDate());
		
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		for(OrderItemDTO orderItemDTO : orderDTO.getOrderItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setItemPrice(orderItemDTO.getItemPrice());
			orderItem.setItemQuantity(orderItemDTO.getItemQuantity());
			orderItem.setProduct_id(orderItemDTO.getProduct_id());
			orderItems.add(orderItem);
		}
		order.setOrderItems(orderItems);
		order.setOrderStatus(orderDTO.getOrderStatus());
		order.setPaymentStatus(orderDTO.getPaymentStatus());
		order.setOrderTotalPrice(orderDTO.getOrderTotalPrice());
		
		return order;
	}

}
