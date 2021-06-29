package com.ecom.service.order;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecom.constants.ApplicationConstants;
import com.ecom.dto.OrderDTO;
import com.ecom.dto.OrderItemDTO;
import com.ecom.exceptions.OrderException;
import com.ecom.exceptions.ProductException;
import com.ecom.model.OrderItem;
import com.ecom.model.Product;
import com.ecom.repository.ProductRepository;

@Component
public class ProcessOrder {
	
	@Autowired
	ProductRepository productRepository;
	
	public void validateOrder(OrderDTO orderDTO) {
		if(orderDTO.getOrderItems().size() == 0)
			throw new OrderException(ApplicationConstants.ERROR_9004);
		
		orderDTO.getOrderItems().forEach(k -> {
					validateOrderItem(k);
				});
	}
	
	private void validateOrderItem(OrderItemDTO orderItemDTO) {
		int product_id = orderItemDTO.getProduct_id();
		Optional<Product> product = productRepository.findById(product_id);
		if(!product.isPresent())
			throw new ProductException(ApplicationConstants.ERROR_9001);
		
		if(orderItemDTO.getItemQuantity() > product.get().getProductAvlQuantity())
			throw new ProductException(ApplicationConstants.ERROR_9002);
	}

}
