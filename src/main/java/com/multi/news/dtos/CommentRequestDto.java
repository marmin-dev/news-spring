package com.multi.news.dtos;

import com.multi.news.entities.Comment;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentRequestDto {
    private String content;

    public Comment toEntity(){
        return Comment.builder()
                .content(content)
                .author("fakeauthor")
                .post("fakepost")
                .build();

    }
}
