package com.example.jpa.payload.post;

import java.util.List;

public record PostMainRes(

        List<PostResponse> postResponses
) {

}
