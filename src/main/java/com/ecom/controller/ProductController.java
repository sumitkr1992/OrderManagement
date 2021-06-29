package com.ecom.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.constants.ControllerConstants;
import com.ecom.dto.OrderDTO;
import com.ecom.model.Order;
import com.ecom.model.Product;
import com.ecom.service.OrderItemService;
import com.ecom.service.OrderService;
import com.ecom.service.ProductService;

@RestController
@RequestMapping(ControllerConstants.PRODUCT_BASE_PATH)
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderItemService orderItemService;
	
	@RequestMapping(value = ControllerConstants.CREATE_PRODUCT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> saveProduct(@RequestBody Product product, @RequestParam Map<String, String> requestHeaders){
		return productService.save(product);
    }
	
	@RequestMapping(value = ControllerConstants.GET_PRODUCT_INFO, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductInfo(@PathVariable("id") int productId){
		return productService.getProductById(productId);
	}
	
	@RequestMapping(value = ControllerConstants.PLACE_ORDER, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> placeOrder(@RequestBody OrderDTO orderDTO, @RequestParam Map<String, String> requestHeaders){
		return orderService.saveOrder(orderDTO);
    }

}
