package com.multi.news.controllers;

import com.multi.news.dtos.CommentRequestDto;
import com.multi.news.dtos.CommentResponseDto;
import com.multi.news.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentApiController {

    private final CommentService commentService;

    @PostMapping("/save")
    public ResponseEntity<Long> commentCreate(@RequestBody CommentRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.commentCreate(dto));
    }
    // PostMan Test
//    @GetMapping
//    public ResponseEntity<String> commentRead(){
//        return ResponseEntity.status(HttpStatus.OK).body(commentService.commentGet().toString());
//    }
    // update method
    @PutMapping("/{id}")
    public ResponseEntity<Long> commentUpdate(@PathVariable Long id, @RequestBody String content){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.commentUpdate(id, content));
    }
    // delete method
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> commentDelete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.commentDelete(id));
    }
}
