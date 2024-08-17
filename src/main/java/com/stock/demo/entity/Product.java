package com.stock.demo.entity;


import com.stock.demo.request.CreateProductRequest;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private String qtd;

    @Column(name = "price")
    private String price;

    public Product (CreateProductRequest createProductRequest) {
        this.name = createProductRequest.getName();
        this.qtd = createProductRequest.getQtd();
        this.price = createProductRequest.getPrice();
    }
}
