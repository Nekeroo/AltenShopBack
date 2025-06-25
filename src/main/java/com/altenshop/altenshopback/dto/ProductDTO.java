package com.altenshop.altenshopback.dto;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {

    private long idProduct;

    private String code;

    private String name;

    private String description;

    private String image;

    private String category;

    private float price;

    private int quantity;

    private String internalReference;

    private int shellId;

    private String inventoryStatus;

    private float rating;

    private long createdAt;

    private long updatedAt;

}
