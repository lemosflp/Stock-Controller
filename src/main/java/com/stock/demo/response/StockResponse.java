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

    private long id;

//    @JsonProperty("product_name")
    private String name;

    private Integer qtd;

    private Double price;

    private String productType;

    public StockResponse (Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.qtd = product.getQtd();
        this.price = product.getPrice();
        this.productType = product.getProductType();
    }

}
