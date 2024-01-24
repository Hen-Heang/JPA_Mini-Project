package com.example.jpa.controller;

import com.example.jpa.domain.product.Product;
import com.example.jpa.payload.product.ProductRequest;
import com.example.jpa.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product/")
@RequiredArgsConstructor
public class ProductController extends AbstractRestController{
    private final ProductService productService;

    @PostMapping("add")
    public Object addProduct(@RequestBody ProductRequest productRequest){
        productService.addProduct(productRequest);
        return ok();
    }

    @GetMapping("all")
    public Object getAllProduct(){
        return ok( productService.getAllProducts());
    }

    @GetMapping("{id}")
    public Object getProductById(@PathVariable("id")Long id){
        return ok(productService.getProductById(id));
    }

    @PutMapping("{id}")
    public Object updateProduct(@PathVariable("id")Long id, @RequestBody ProductRequest productRequest){
        return ok(productService.updateProduct(id,productRequest));
    }

    @DeleteMapping("{id}")
    public Object deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return ok();
    }

    @GetMapping("{name}")
    public Object  getByName(@PathVariable String name){
        var p = productService.getProductByName(name);

        return ok(p);
    }


}
