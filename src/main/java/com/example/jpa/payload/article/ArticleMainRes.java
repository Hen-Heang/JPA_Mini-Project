package com.example.jpa.payload.article;

import com.example.jpa.common.Pagination;

import java.util.List;

public record ArticleMainRes(
        List<ArticleResponse> articleResponseList,
        Pagination pagination

        ) {
}
