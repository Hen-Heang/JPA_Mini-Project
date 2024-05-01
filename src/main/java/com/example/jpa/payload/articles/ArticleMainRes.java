package com.example.jpa.payload.articles;

import com.example.jpa.common.Pagination;

import java.util.List;

public record ArticleMainRes(
        List<ArticleResponse> articleResponseList,
        Pagination pagination

        ) {
}
