package com.example.jpa.payload.category;

import java.util.List;

public record CategoryMainRes(
    List<CategoryResponse>categoryResponses

) {
}
