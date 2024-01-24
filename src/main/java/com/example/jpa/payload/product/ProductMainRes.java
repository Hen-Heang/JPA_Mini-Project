package com.example.jpa.payload.product;

import com.example.jpa.payload.post.PostResponse;

import java.util.List;

public record ProductMainRes(

        List<ProductResponse> productResponses
) {
}
