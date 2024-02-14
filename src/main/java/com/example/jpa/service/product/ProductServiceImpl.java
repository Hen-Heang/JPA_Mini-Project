package com.example.jpa.service.product;

import com.example.jpa.domain.product.Product;
import com.example.jpa.domain.product.ProductRepository;
import com.example.jpa.exception.CusNotFoundException;
import com.example.jpa.payload.product.ProductMainRes;
import com.example.jpa.payload.product.ProductRequest;
import com.example.jpa.payload.product.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public void addProduct(ProductRequest productRequest) {
        var product = productMapper.mapToEntityProduct(productRequest);
        productRepository.save(product);
    }

    @Override
    public Object getAllProducts() {
        var productResponse = productRepository.findAll();
        List<ProductResponse> productResponseList = productResponse.stream()
                .map(productMapper::mapToResponse).toList();
        return new ProductMainRes(productResponseList);
    }

    @Override
    public Object getProductById(Long id) {

        return productRepository.findById(id)
                .map(productMapper::mapToResponse)
                .orElseThrow(() -> new CusNotFoundException("Product Not Fount!"));
    }

    @Override
    public Object updateProduct(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new CusNotFoundException("Product Not Found!"));
        productMapper.updateEntityProduct(product, productRequest);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Object getProductByName(String name) {
        return productRepository.findByName(name);
    }

}
