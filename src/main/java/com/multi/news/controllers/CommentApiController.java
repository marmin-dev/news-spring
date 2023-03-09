package com.multi.news.controllers;

import com.multi.news.dtos.CommentRequestDto;
import com.multi.news.dtos.CommentResponseDto;
import com.multi.news.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentApiController {

    private final CommentService commentService;
    @PostMapping
    public ResponseEntity<Long> commentCreate(@RequestBody CommentRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.commentCreate(dto));
    }
}
