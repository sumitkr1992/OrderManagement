package com.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecom.constants.ApplicationConstants;
import com.ecom.exceptions.GeneralException;
import com.ecom.exceptions.ItemException;
import com.ecom.model.OrderItem;
import com.ecom.repository.OrderItemsRepository;

@Service
public class OrderItemService {

	@Autowired
	OrderItemsRepository orderItemsRepository;

	public ResponseEntity<OrderItem> getProductById(Integer orderItemId) {

		OrderItem orderItem = null;
		try {
			orderItem = orderItemsRepository.findById(orderItemId)
					.orElseThrow(() -> new ItemException(ApplicationConstants.ERROR_9001));
		} catch (ItemException e) {
			throw e;
		} catch (Exception e) {
			throw new GeneralException(e.getLocalizedMessage());
		}
		return new ResponseEntity<>(orderItem, null, HttpStatus.OK);
	}

	public ResponseEntity<OrderItem> save(OrderItem inpOrderItem) {

		OrderItem orderItem = null;
		try {
			// In Utils validateProducts(inpProduct);
			orderItem = orderItemsRepository.save(inpOrderItem);
			if (orderItem == null)
				throw new ItemException(ApplicationConstants.ERROR_9003);
		} catch (ItemException e) {
			throw e;
		} catch (Exception e) {
			throw new GeneralException(e.getLocalizedMessage());
		}
		return new ResponseEntity<>(orderItem, null, HttpStatus.OK);
	}

}
