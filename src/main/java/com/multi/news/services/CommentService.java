package com.multi.news.services;

import com.multi.news.dtos.CommentRequestDto;
import com.multi.news.dtos.CommentResponseDto;
import com.multi.news.dtos.SessionUser;
import com.multi.news.entities.Comment;
import com.multi.news.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    private final HttpSession httpSession;

    // 댓글 달기 메서드
    @Transactional
    public Long commentCreate(CommentRequestDto dto){
        SessionUser user =(SessionUser) httpSession.getAttribute("user");
        Comment comment = Comment.builder().content(dto.getContent())
                .author(user.getName())
                .category(dto.getCategory())
                .build();

        return commentRepository.save(comment).getId();

    }
    // 게시물 별 댓글 찾기 메세드, 최신순 정렬
    @Transactional
    public List<CommentResponseDto> commentGet(String category){
        List<CommentResponseDto> comment = commentRepository.findByCategory(category,Sort.by(Sort.Order.
                        desc("id"))).stream()
                .map(comment1 -> new CommentResponseDto(comment1)).collect(Collectors.toList());
        return comment;
    }
    // 댓글 수정 버튼 누를 시 발생
    @Transactional
    public Long commentUpdate(Long id,String content){
        Comment comment=commentRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시물이 존재하지 않음"));
        comment.setContent(content);
        return id;
    }
    // 삭제 버튼 누를시 연결될 메서드
    @Transactional
    public Long commentDelete(Long id){
        commentRepository.deleteById(id);
        return id;
    }
    @Transactional
    public CommentResponseDto findComment(Long id){
        Comment comment = commentRepository.findById(id).get();
        CommentResponseDto dto = new CommentResponseDto(comment);
        return dto;
    }
}
