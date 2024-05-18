package com.harshit.productservice.service;

import com.harshit.productservice.dto.ProductRequest;
import com.harshit.productservice.dto.ProductResponse;
import com.harshit.productservice.model.Product;
import com.harshit.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest request){
        Product product = Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .build();
        productRepository.save(product);

        log.info("Product created successfully");

        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }
}
