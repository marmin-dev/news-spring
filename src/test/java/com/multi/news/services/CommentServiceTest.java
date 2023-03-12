package com.multi.news.services;

import com.multi.news.dtos.CommentRequestDto;
import com.multi.news.entities.Comment;
import com.multi.news.repositories.CommentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CommentServiceTest {

    @Autowired
    CommentService commentService;

    @Autowired
    CommentRepository commentRepository;

    @BeforeEach
    public void clearAll(){
        commentRepository.deleteAll();
    }

//    @Test
//    public void createTest(){
//        CommentRequestDto dto = new CommentRequestDto("content");
//        Long key= commentService.commentCreate(dto);
//        Comment comment = commentRepository.findByAuthor("fakeauthor");
//        Assertions.assertEquals(key,comment.getId());
//    }
}
