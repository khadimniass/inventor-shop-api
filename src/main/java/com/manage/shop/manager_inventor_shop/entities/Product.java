package com.manage.shop.manager_inventor_shop.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private Integer minStockLevel;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
