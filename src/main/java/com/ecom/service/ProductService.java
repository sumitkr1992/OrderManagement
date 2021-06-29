package com.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecom.constants.ApplicationConstants;
import com.ecom.exceptions.GeneralException;
import com.ecom.exceptions.ProductException;
import com.ecom.model.Product;
import com.ecom.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {
	@Autowired
    private ProductRepository productRepository;
	
	public ResponseEntity<Product> getProductById(Integer productId) {
		
		Product product = null;
		try {
			product = productRepository
			          .findById(productId)
			          .orElseThrow(() -> new ProductException(ApplicationConstants.ERROR_9001));
		}catch(ProductException e) {
			throw e;
		}catch(Exception e) {
			throw new GeneralException(e.getLocalizedMessage());
		}
		return new ResponseEntity<>(product, null, HttpStatus.OK);
    }
	
	public ResponseEntity<Product> save(Product inpProduct) {
        
        Product product = null;
		try {
			//In Utils validateProducts(inpProduct);
			product = productRepository
			          .save(inpProduct);
			if(product == null)
				throw new ProductException(ApplicationConstants.ERROR_9003);
		}catch(ProductException e) {
			throw e;
		}catch(Exception e) {
			throw new GeneralException(e.getLocalizedMessage());
		}
		return new ResponseEntity<>(product, null, HttpStatus.OK);
    }
	
	public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
