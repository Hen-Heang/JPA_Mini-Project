package com.example.jpa.payload.category;

import com.example.jpa.common.Pagination;

import java.util.List;

public record CategoryMainRes(
    List<CategoryResponse>categoryResponses,
    Pagination pagination


) {
}
