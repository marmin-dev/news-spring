package com.multi.news.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.multi.news.dtos.NewsResponseDto;
import com.multi.news.services.NewsApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final NewsApiService newsApiService;
    private final CommentApiController commentApiController;

    //main
    @GetMapping("/")
    public String index(Model model) throws JsonProcessingException {
        model.addAttribute("news",newsApiService.newsAll());
        return "index";
    }
    //business
    @GetMapping("/business")
    public String businessNews(Model model) throws JsonProcessingException {
        model.addAttribute("news",newsApiService.newsBusiness());
        return "business";
    }
    //entertainment
    @GetMapping("/entertainment")
    public String entertainmentNews(Model model) throws JsonProcessingException {
        model.addAttribute("news",newsApiService.newsEntertainment());
        return "entertainment";
    }
    //health
    @GetMapping("/health")
    public String healthNews(Model model) throws JsonProcessingException {
        model.addAttribute("news",newsApiService.newsHealth());
        return "health";
    }
    //science
    @GetMapping("/science")
    public String scienceNews(Model model) throws JsonProcessingException {
        model.addAttribute("news",newsApiService.newsScience());
        return "science";
    }
    //sports
    @GetMapping("/sports")
    public String sportsNews(Model model) throws JsonProcessingException {
        model.addAttribute("news",newsApiService.newsSports());
        return "sports";
    }
    //technology
    @GetMapping("/technology")
    public String technologyNews(Model model) throws JsonProcessingException {
        model.addAttribute("news",newsApiService.newsTechnology());
        return "technology";
    }
    @GetMapping("/{}")
    public String getDetail(@PathVariable String post, Model model) throws JsonProcessingException {
        model.addAttribute("news",newsApiService.newsDetail(post));
        return "newsdetail";
    }

}
