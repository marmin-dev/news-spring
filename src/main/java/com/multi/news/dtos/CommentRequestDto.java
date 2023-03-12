package com.multi.news.dtos;

import com.multi.news.entities.Comment;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentRequestDto {
    private String content;

    private String category;

    public Comment toEntity(){
        return Comment.builder()
                .content(content)
                .category(category)
                .author("fakeauthor")
                .build();

    }
}
