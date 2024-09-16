package com.example.order_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orders") // Rename the table to "orders"
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private int quantity;
    private String customerName;
    private String orderDate;

    // Default constructor (required by JPA)
    public Order() {}

    // Constructor for service usage
    public Order(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    // Constructor with all fields
    public Order(String productName, int quantity, String customerName, String orderDate) {
        this.productName = productName;
        this.quantity = quantity;
        this.customerName = customerName;
        this.orderDate = orderDate;
    }
}
