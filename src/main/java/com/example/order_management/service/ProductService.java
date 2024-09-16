package com.example.order_management.service;

import com.example.order_management.model.Product;
import com.example.order_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Create a product
    public Product createProduct(String productName, int quantity) {
        Product product = new Product();
        product.setProductName(productName);
        product.setQuantity(quantity);
        return productRepository.save(product);
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get a product by ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Update a product
    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setProductName(productDetails.getProductName());
        product.setQuantity(productDetails.getQuantity());
        return productRepository.save(product);
    }

    // Delete a product by ID
    public boolean deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            productRepository.delete(product);
            return true;
        }
        return false;
    }
}
