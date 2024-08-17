package com.stock.demo.service;

import com.stock.demo.entity.Product;
import com.stock.demo.repository.ProductRepository;
import com.stock.demo.request.CreateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct (CreateProductRequest createProductRequest) {
        Product product = new Product(createProductRequest);

        product = productRepository.save(product);
        return product;
    }
}
