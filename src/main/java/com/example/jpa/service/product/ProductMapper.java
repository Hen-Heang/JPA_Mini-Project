package com.example.jpa.service.product;

import com.example.jpa.domain.product.Product;
import com.example.jpa.payload.product.ProductRequest;
import com.example.jpa.payload.product.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product mapToEntityProduct(ProductRequest productRequest) {

        return Product.builder()
                .name(productRequest.name())
                .price(productRequest.price())
                .qty(productRequest.quantity())
                .description(productRequest.description())
                .date(productRequest.date())
                .rating(productRequest.rating())
                .build();
    }

    public ProductResponse mapToResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .description(product.getDescription())
                .date(product.getDate())
                .rating(product.getRating())
                .build();

    }

    public void updateEntityProduct(Product product, ProductRequest productRequest) {
        product.setName(productRequest.name());
        product.setPrice(productRequest.price());
        product.setQuantity(productRequest.quantity());
        product.setDescription(productRequest.description());
        product.setDate(productRequest.date());
        product.setRating(productRequest.rating());


    }
}
