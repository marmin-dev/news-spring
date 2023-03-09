package com.multi.news.services;

import com.multi.news.dtos.CommentRequestDto;
import com.multi.news.entities.Comment;
import com.multi.news.repositories.CommentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CommentServiceTest {

    @Autowired
    CommentRepository commentRepository;
    @Test
    public void createTest(){
        CommentRequestDto dto = new CommentRequestDto("comment");
        Comment comment = commentRepository.save(dto.toEntity());
        Assertions.assertEquals("comment", comment.getContent());



    }
}
