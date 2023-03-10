package com.multi.news.services;

import com.multi.news.dtos.CommentRequestDto;
import com.multi.news.dtos.CommentResponseDto;
import com.multi.news.entities.Comment;
import com.multi.news.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    // 댓글 달기 메서드
    @Transactional
    public Long commentCreate(CommentRequestDto dto){
        return commentRepository.save(dto.toEntity()).getId();
    }

    // 게시물 별 댓글 찾기 메세드, 최신순 정렬
    @Transactional
    public List<CommentResponseDto> commentGet(){
        List<CommentResponseDto> comment = commentRepository.findByPost("fakepost",Sort.by(Sort.Order.
                        desc("id"))).stream()
                .map(comment1 -> new CommentResponseDto(comment1)).collect(Collectors.toList());
        return comment;
    }
    // 댓글 수정 버튼 누를 시 발생
    @Transactional
    public Long commentUpdate(Long id,CommentRequestDto dto){
        Comment comment=commentRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시물이 존재하지 않음"));
        comment.setContent(dto.getContent());
        return id;
    }
    // 삭제 버튼 누를시 연결될 메서드
    @Transactional
    public Long commentDelete(Long id){
        commentRepository.deleteById(id);
        return id;
    }
}
