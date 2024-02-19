package com.example.jpa.domain.article;

import com.example.jpa.domain.bookmark.BookmarkDTO;
import com.example.jpa.domain.category.CategoryDTO;
import com.example.jpa.domain.comment.CommentDTO;
import com.example.jpa.domain.user.UserDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter

public class ArticleDTO {
private Long id;
    private String title;
    private String description;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserDTO userDTO;

    private List<CommentDTO>comments = new ArrayList<>();
    @JsonInclude(JsonInclude.Include.NON_EMPTY)

    private List<CategoryDTO>categoryDTOS;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BookmarkDTO> bookmarkDTOS;
    private Boolean published;

    public ArticleDTO(Long id, String title, String description, Boolean published, UserDTO userDTO, List<CommentDTO>commentDTOS,List<CategoryDTO>categoryDTOS){
        this.id = id;
        this.title=title;
        this.description=description;
        this.published= published;
        this.userDTO=userDTO;
        this.comments = commentDTOS;
        this.categoryDTOS=categoryDTOS;
    }


}
