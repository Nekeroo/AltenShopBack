package com.altenshop.altenshopback.repositories;

import com.altenshop.altenshopback.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>{

    void deleteByIdProduct(Long idProduct);

    Optional<Product> getByIdProduct(Long idProduct);

}
