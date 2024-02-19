package com.example.jpa.payload.article;

import java.util.List;

public record ArticleMainRes(
        List<ArticleResponse> articleResponseList
) {
}
