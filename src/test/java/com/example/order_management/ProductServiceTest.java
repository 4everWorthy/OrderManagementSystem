package com.example.order_management;

import com.example.order_management.model.Product;
import com.example.order_management.repository.ProductRepository;
import com.example.order_management.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product testProduct;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create a sample product for testing
        testProduct = new Product();
        testProduct.setId(1L);
        testProduct.setProductName("Monitor");
        testProduct.setQuantity(3);
    }

    @Test
    void createProduct_shouldReturnSavedProduct() {
        // Arrange: Mock repository behavior
        when(productRepository.save(any(Product.class))).thenReturn(testProduct);

        // Act: Call the service method
        Product savedProduct = productService.createProduct("Monitor", 3);

        // Assert: Verify the result
        assertNotNull(savedProduct);
        assertEquals("Monitor", savedProduct.getProductName());
        assertEquals(3, savedProduct.getQuantity());

        // Verify that save was called once
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void getProductById_shouldReturnProductIfExists() {
        // Arrange: Mock repository behavior
        when(productRepository.findById(1L)).thenReturn(Optional.of(testProduct));

        // Act: Call the service method
        Product foundProduct = productService.getProductById(1L);

        // Assert: Verify the result
        assertNotNull(foundProduct);
        assertEquals(1L, foundProduct.getId());
        assertEquals("Monitor", foundProduct.getProductName());
        assertEquals(3, foundProduct.getQuantity());

        // Verify that findById was called once
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    void getProductById_shouldReturnNullIfNotFound() {
        // Arrange: Mock repository behavior
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        // Act: Call the service method
        Product foundProduct = productService.getProductById(1L);

        // Assert: Verify the result
        assertNull(foundProduct);

        // Verify that findById was called once
        verify(productRepository, times(1)).findById(1L);
    }
}
