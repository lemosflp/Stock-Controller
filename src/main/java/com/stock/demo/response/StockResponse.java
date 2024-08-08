package com.stock.demo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stock.demo.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StockResponse {

    @JsonProperty("Product ID")
    private long id;

    @JsonProperty("Product Name")
    private String name;

    @JsonProperty("Quantity")
    private int qtd;

    @JsonProperty("Price")
    private Double price;

    public StockResponse (Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.qtd = product.getQtd();
        this.price = product.getPrice();
    }

}
