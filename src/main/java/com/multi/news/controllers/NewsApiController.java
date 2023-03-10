package com.multi.news.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.multi.news.dtos.NewsResponseDto;
import com.multi.news.services.NewsApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v2/news")
@RestController
@RequiredArgsConstructor
public class NewsApiController {

    private final NewsApiService newsApiService;

    @GetMapping
    public ResponseEntity<String> getAllNews() throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).body(newsApiService.newsAll().toString());
    }
    // 비즈니스 뉴스
    @GetMapping("/business")
    public ResponseEntity<String> getBusinessNews() throws JsonProcessingException{
        return ResponseEntity.status(HttpStatus.OK).body(newsApiService.newsBusiness().toString());
    }
    // 엔터테인먼트
    @GetMapping("/entertainment")
    public ResponseEntity<String> getEntertainmentNews() throws JsonProcessingException{
        return ResponseEntity.status(HttpStatus.OK).body(newsApiService.newsEntertainment().toString());
    }
    // 건강
    @GetMapping("/health")
    public ResponseEntity<String> getHealthNews() throws JsonProcessingException{
        return ResponseEntity.status(HttpStatus.OK).body(newsApiService.newsHealth().toString());
    }
    // 과학
    @GetMapping("/science")
    public ResponseEntity<String> getScienceNews() throws JsonProcessingException{
        return ResponseEntity.status(HttpStatus.OK).body(newsApiService.newsScience().toString());
    }
    // 스포츠
    @GetMapping("/sports")
    public ResponseEntity<String> getSportsNews() throws JsonProcessingException{
        return ResponseEntity.status(HttpStatus.OK).body(newsApiService.newsSports().toString());
    }
    // 기술
    @GetMapping("/technology")
    public ResponseEntity<String> getTechnologyNews() throws JsonProcessingException{
        return ResponseEntity.status(HttpStatus.OK).body(newsApiService.newsTechnology().toString());
    }
    @GetMapping("/{}")
    public ResponseEntity<NewsResponseDto> getDetail(@PathVariable String post) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).body(newsApiService.newsDetail(post));
    }


}
