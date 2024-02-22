package com.example.jpa.payload.comment;

import java.util.List;

public record CommentMainRes(
        List<CommentResponse> commentResponses

) {
}
