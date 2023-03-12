package com.multi.news.repositories;

import com.multi.news.entities.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByCategory(String category, Sort sort);

    Comment findByAuthor(String author);


}
