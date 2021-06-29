package com.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecom.constants.ApplicationConstants;
import com.ecom.dto.OrderDTO;
import com.ecom.exceptions.GeneralException;
import com.ecom.exceptions.ItemException;
import com.ecom.exceptions.OrderException;
import com.ecom.exceptions.ProductException;
import com.ecom.model.Order;
import com.ecom.model.OrderItem;
import com.ecom.repository.OrderRepository;
import com.ecom.service.order.ProcessOrder;
import com.ecom.utils.OrderUtils;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProcessOrder processOrder;
	
	public ResponseEntity<Order> getOrderById(Integer orderId) {

		Order order = null;
		try {
			order = orderRepository.findById(orderId)
					.orElseThrow(() -> new OrderException(ApplicationConstants.ERROR_9001));
		} catch (OrderException e) {
			throw e;
		} catch (Exception e) {
			throw new GeneralException(e.getLocalizedMessage());
		}
		return new ResponseEntity<>(order, null, HttpStatus.OK);
	}

	public ResponseEntity<Order> save(Order inpOrder) {

		Order order = null;
		try {
			//OrderUtils.initializeOrder(inpOrder);
			order = orderRepository.save(inpOrder);
			if (order == null)
				throw new OrderException(ApplicationConstants.ERROR_9003);
		} catch (OrderException e) {
			throw e;
		} catch (Exception e) {
			throw new GeneralException(e.getLocalizedMessage());
		}
		return new ResponseEntity<>(order, null, HttpStatus.OK);
	}
	
	public ResponseEntity<Order> saveOrder(OrderDTO orderDTO) {

		Order order = null;
		try {
			processOrder.validateOrder(orderDTO);
			OrderUtils.initializeOrder(orderDTO);
			order = OrderUtils.transformToOrder(orderDTO);
			order = orderRepository.save(order);
			if (order == null)
				throw new OrderException(ApplicationConstants.ERROR_9003);
		} catch (OrderException e) {
			throw e;
		} catch (ProductException e) {
			throw e;
		} catch (Exception e) {
			throw new GeneralException(e.getLocalizedMessage());
		}
		return new ResponseEntity<>(order, null, HttpStatus.OK);
	}

}
