package com.ecom.model;

import lombok.Data;
import javax.persistence.*;
//import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "OrderItem")
public @Data class OrderItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "item_quantity")
    private @NotNull int itemQuantity;

    @Column(name = "item_price")
    private @NotNull double itemPrice;
    
//    @ManyToOne
//    @JoinColumn(name = "order_id", referencedColumnName = "id")
//    private Order orders;

//    @OneToOne(targetEntity = Product.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
//    private Product product;
    
    private @NotNull int product_id;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public OrderItem(){}
	
	public OrderItem(@NotNull int product_id, @NotNull int quantity, @NotNull double price) {
        this.product_id = product_id;
        this.itemQuantity = quantity;
        this.itemPrice = price;
        //this.orders= order;
    }

}
