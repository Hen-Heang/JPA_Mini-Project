package com.example.jpa.payload.comment;

import com.example.jpa.common.Pagination;

import java.util.List;

public record CommentMainRes(
        List<CommentResponse> commentResponses
        ) {
}
