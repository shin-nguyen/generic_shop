package com.example.generic_shop.service.Impl;

import com.example.generic_shop.entity.Product;
import com.example.generic_shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl {
    private final ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }
}
