package com.example.jpa.service.product;

import com.example.jpa.payload.product.ProductRequest;

public interface ProductService {


    void addProduct(ProductRequest productRequest);

    Object getAllProducts();

    Object getProductById(Long id);

    Object updateProduct(Long id, ProductRequest productRequest);

    void deleteProduct(Long id);

    Object getProductByName(String name);

}
