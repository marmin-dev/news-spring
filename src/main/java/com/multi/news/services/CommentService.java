package com.multi.news.services;

import com.multi.news.dtos.CommentRequestDto;
import com.multi.news.dtos.CommentResponseDto;
import com.multi.news.entities.Comment;
import com.multi.news.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Long commentCreate(CommentRequestDto dto){
        return commentRepository.save(dto.toEntity()).getId();
    }





}
