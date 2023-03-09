package com.multi.news.repositories;

import com.multi.news.entities.Comment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @BeforeEach
    public void initial(){
        commentRepository.deleteAll();
    }

    @Test
    public void repositorySaveTest() {
        Comment comment = Comment.builder()
                .author("kim")
                .content("funny")
                .build();
        Comment comment1 =commentRepository.save(comment);

        Assertions.assertEquals("kim",comment1.getAuthor());
        Assertions.assertEquals("funny",comment1.getContent());
        System.out.println(comment1.getModifiedDate());
    }

    @Test
    public void repositorySelectTest(){
        Comment comment = Comment.builder()
                .author("kim")
                .content("funny")
                .build();
        Comment comment1 = commentRepository.save(comment);
        Comment comment2 = commentRepository.findByAuthor("kim");
        Assertions.assertEquals(comment1.getAuthor(),comment2.getAuthor());
        Assertions.assertEquals(comment1.getContent(),comment2.getContent());
        System.out.println(comment2.getModifiedDate());
    }
}
