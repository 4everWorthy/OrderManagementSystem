package com.example.order_management;

import com.example.order_management.model.Order;
import com.example.order_management.repository.OrderRepository;
import com.example.order_management.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    private Order testOrder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create a sample order for testing
        testOrder = new Order();
        testOrder.setId(1L);
        testOrder.setProductName("Laptop");
        testOrder.setQuantity(1);
        testOrder.setCustomerName("John Doe");
        testOrder.setOrderDate("2024-09-16");
    }

    @Test
    void createOrder_shouldReturnSavedOrder() {
        // Arrange: Mock repository behavior
        when(orderRepository.save(any(Order.class))).thenReturn(testOrder);

        // Create a new order to pass to the createOrder method
        Order newOrder = new Order();
        newOrder.setProductName("Laptop");
        newOrder.setQuantity(1);
        newOrder.setCustomerName("John Doe");
        newOrder.setOrderDate("2024-09-16");

        // Act: Call the service method
        Order savedOrder = orderService.createOrder(newOrder);

        // Assert: Verify the result
        assertNotNull(savedOrder);
        assertEquals("Laptop", savedOrder.getProductName());
        assertEquals(1, savedOrder.getQuantity());
        assertEquals("John Doe", savedOrder.getCustomerName());
        assertEquals("2024-09-16", savedOrder.getOrderDate());

        // Verify that save was called once
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    void getOrderById_shouldReturnOrderIfExists() {
        // Arrange: Mock repository behavior
        when(orderRepository.findById(1L)).thenReturn(Optional.of(testOrder));

        // Act: Call the service method
        Order foundOrder = orderService.getOrderById(1L);

        // Assert: Verify the result
        assertNotNull(foundOrder);
        assertEquals(1L, foundOrder.getId());
        assertEquals("Laptop", foundOrder.getProductName());
        assertEquals(1, foundOrder.getQuantity());

        // Verify that findById was called once
        verify(orderRepository, times(1)).findById(1L);
    }

    @Test
    void getOrderById_shouldReturnNullIfNotFound() {
        // Arrange: Mock repository behavior
        when(orderRepository.findById(1L)).thenReturn(Optional.empty());

        // Act: Call the service method
        Order foundOrder = orderService.getOrderById(1L);

        // Assert: Verify the result
        assertNull(foundOrder);

        // Verify that findById was called once
        verify(orderRepository, times(1)).findById(1L);
    }
}
