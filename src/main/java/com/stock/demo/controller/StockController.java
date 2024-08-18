package com.stock.demo.controller;

import com.stock.demo.entity.Product;
import com.stock.demo.request.CreateProductRequest;
import com.stock.demo.request.UpdateProductRequest;
import com.stock.demo.response.StockResponse;
import com.stock.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/stock/")
public class StockController {

    @Autowired
    ProductService productService;

    @GetMapping("getAll")
    public List<StockResponse> getAllProducts(){
        List<Product> productList = productService.getAllProducts();
        List<StockResponse> productResponseList = new ArrayList<StockResponse>();

        productList.stream().forEach(product -> {
            productResponseList.add(new StockResponse(product));
        });

        return productResponseList;
    }

    @PostMapping("create")
    public StockResponse createProduct (@RequestBody @Valid CreateProductRequest createProductRequest) {
       Product product = productService.createProduct(createProductRequest);

       return new StockResponse(product);
    }

    @PutMapping("updatePrice")
    public StockResponse updatePrice (@Valid @RequestBody UpdateProductRequest updateProductRequest) {
        Product product = productService.updatePrice(updateProductRequest);

        return new StockResponse(product);
    }

    @PutMapping("updateType")
    public StockResponse updateType (@Valid @RequestBody UpdateProductRequest updateProductRequest) {
        Product product = productService.updateType(updateProductRequest);

        return new StockResponse(product);
    }

}

