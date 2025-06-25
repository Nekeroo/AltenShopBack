package com.altenshop.altenshopback.services;

import com.altenshop.altenshopback.dto.ProductDTO;
import com.altenshop.altenshopback.models.Product;
import com.altenshop.altenshopback.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteByIdProduct(id);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.getByIdProduct(id);
    }

    @Transactional
    public void updateProduct(Product product, Long id) {
        Product existingProduct = productRepository.getByIdProduct(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setDescription(product.getDescription());

        productRepository.save(existingProduct);

    }

}
