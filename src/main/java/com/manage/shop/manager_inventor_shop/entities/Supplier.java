package com.manage.shop.manager_inventor_shop.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "suppliers")
public class Supplier { // Fournisseuse
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contact;



    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<Product> products;

}
