package com.altenshop.altenshopback.controllers;

import com.altenshop.altenshopback.dto.ProductDTO;
import com.altenshop.altenshopback.mappers.ProductMapper;
import com.altenshop.altenshopback.models.Product;
import com.altenshop.altenshopback.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllProducts() {
        List<ProductDTO> productDTOs = productService.getAllProduct().stream()
                .map(productMapper::mapProductToProductDTO)
                .toList();

        return ResponseEntity.ok().body(productDTOs);
    }

    @PostMapping("/")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) {

        Product product = productMapper.mapProductDTOtoProduct(productDTO);

        productService.saveProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO productDTO) {

        Product product = productMapper.mapProductDTOtoProduct(productDTO);

        productService.updateProduct(product, product.getIdProduct());

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {

        Optional<Product> product = productService.getProductById(id);

        if (product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

        productService.deleteProduct(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
