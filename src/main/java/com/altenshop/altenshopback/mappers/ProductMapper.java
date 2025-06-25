package com.altenshop.altenshopback.mappers;

import com.altenshop.altenshopback.dto.ProductDTO;
import com.altenshop.altenshopback.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDTO mapProductToProductDTO(Product product) {
        if (product == null) {
            return null;
        }

        return ProductDTO.builder()
                .idProduct(product.getIdProduct())
                .code(product.getCode())
                .name(product.getName())
                .description(product.getDescription())
                .image(product.getImage())
                .category(product.getCategory())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .internalReference(product.getInternalReference())
                .shellId(product.getShellId())
                .inventoryStatus(product.getInventoryStatus())
                .rating(product.getRating())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }

    public Product mapProductDTOtoProduct(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }

        return Product.builder()
                .idProduct(productDTO.getIdProduct())
                .code(productDTO.getCode())
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .image(productDTO.getImage())
                .category(productDTO.getCategory())
                .price(productDTO.getPrice())
                .quantity(productDTO.getQuantity())
                .internalReference(productDTO.getInternalReference())
                .shellId(productDTO.getShellId())
                .inventoryStatus(productDTO.getInventoryStatus())
                .rating(productDTO.getRating())
                .createdAt(productDTO.getCreatedAt())
                .updatedAt(productDTO.getUpdatedAt())
                .build();
    }

}
