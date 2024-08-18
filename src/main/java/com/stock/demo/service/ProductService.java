package com.stock.demo.service;

import com.stock.demo.entity.Product;
import com.stock.demo.repository.ProductRepository;
import com.stock.demo.request.CreateProductRequest;
import com.stock.demo.request.UpdateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Product updatePrice (UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(updateProductRequest.getId()).get();

        if (updateProductRequest.getPrice() != null &&
            !updateProductRequest.getPrice().isNaN()) {
            product.setPrice(updateProductRequest.getPrice());
        }

        product = productRepository.save(product);

        return product;
    }

    public Product updateType (UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(updateProductRequest.getId()).get();

        product.setProductType(updateProductRequest.getProductType());

        product = productRepository.save(product);

        return product;
    }
}
