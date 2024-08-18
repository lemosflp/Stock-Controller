package com.stock.demo.request;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductRequest {

    @NotNull(message = "Product Id is required")
    private Integer id;

    private String name;

    private Integer qtd;

    private Double price;

    private String productType;
}
