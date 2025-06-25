package com.altenshop.altenshopback.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "id_product", nullable = false)
    private long idProduct;

    private String code;

    private String name;

    private String description;

    private String image;

    private String category;

    private float price;

    private int quantity;

    @Column(name = "internal_reference")
    private String internalReference;

    @Column(name = "shell_id")
    private int shellId;

    private String inventoryStatus;

    private float rating;

    @Column(name = "created_at")
    private long createdAt;

    @Column(name = "updated_at")
    private long updatedAt;

}
