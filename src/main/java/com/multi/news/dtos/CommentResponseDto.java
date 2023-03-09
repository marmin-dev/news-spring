package com.multi.news.dtos;

import com.multi.news.entities.Comment;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentResponseDto {
    private Long id;

    private String author;

    private String content;

    private LocalDateTime modifiedDate;

    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.author = comment.getAuthor();
        this.content = comment.getContent();
        this.modifiedDate = comment.getModifiedDate();

    }

}
