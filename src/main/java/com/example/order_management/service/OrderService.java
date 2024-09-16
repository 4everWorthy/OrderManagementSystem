package com.example.order_management.service;

import com.example.order_management.model.Order;
import com.example.order_management.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Method to create an Order by accepting an Order object directly
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Retrieve all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Retrieve an order by ID
    public Order getOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    // Update an order by ID
    public Order updateOrder(Long id, Order orderDetails) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            Order existingOrder = order.get();
            existingOrder.setProductName(orderDetails.getProductName());
            existingOrder.setQuantity(orderDetails.getQuantity());
            existingOrder.setCustomerName(orderDetails.getCustomerName());
            existingOrder.setOrderDate(orderDetails.getOrderDate());
            return orderRepository.save(existingOrder);
        } else {
            return null;
        }
    }

    // Delete an order by ID
    public boolean deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
