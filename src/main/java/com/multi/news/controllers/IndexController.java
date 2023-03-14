package com.multi.news.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.multi.news.dtos.SessionUser;
import com.multi.news.services.CommentService;
import com.multi.news.services.NewsApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final NewsApiService newsApiService;
    private final CommentService commentService;

    private final HttpSession httpSession;

    String[] cate = {"all","business","entertainment","health","science","sports","technology"};
    List<String> categories = Arrays.asList(cate);

    //main
    @GetMapping("/")
    public String index(Model model) throws JsonProcessingException {
        model.addAttribute("news", newsApiService.newsGet("all"));
        model.addAttribute("comment", commentService.commentGet("all"));
        model.addAttribute("category","all");
        SessionUser user =(SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }
    @GetMapping("/{category}")
    public String newsBack(@PathVariable String category, Model model) throws JsonProcessingException {
        model.addAttribute("news", newsApiService.newsGet(category));
        model.addAttribute("comment", commentService.commentGet(category));
        model.addAttribute("category",category);
        SessionUser user =(SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        if(categories.contains(category)){
            return "index";
        }else{
            return "page404";
        }
    }
    @GetMapping("/{category}/{id}")
    public String updateForm(@PathVariable String category, @PathVariable Long id, Model model) throws JsonProcessingException {
        model.addAttribute("news", newsApiService.newsGet(category));
        model.addAttribute("comment", commentService.commentGet(category));
        model.addAttribute("category",category);
        model.addAttribute("commentupdate",commentService.findComment(id));
        SessionUser user =(SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        return "updateform";
    }
//
//    //business
//    @GetMapping("/business")
//    public String businessNews(Model model) throws JsonProcessingException {
//        model.addAttribute("news", newsApiService.newsBusiness());
//        model.addAttribute("comment", commentService.commentGet("business"));
//        model.addAttribute("category","business");
//        SessionUser user =(SessionUser) httpSession.getAttribute("user");
//        if(user != null){
//            model.addAttribute("userName",user.getName());
//        }
//        return "business";
//    }
//
//    //entertainment
//    @GetMapping("/entertainment")
//    public String entertainmentNews(Model model) throws JsonProcessingException {
//        model.addAttribute("news", newsApiService.newsEntertainment());
//        model.addAttribute("comment", commentService.commentGet("entertainment"));
//        model.addAttribute("category","entertainment");
//        SessionUser user =(SessionUser) httpSession.getAttribute("user");
//        if(user != null){
//            model.addAttribute("userName",user.getName());
//        }
//        return "entertainment";
//    }
//
//    //health
//    @GetMapping("/health")
//    public String healthNews(Model model) throws JsonProcessingException {
//        model.addAttribute("news", newsApiService.newsHealth());
//        model.addAttribute("comment", commentService.commentGet("health"));
//        model.addAttribute("category","health");
//        SessionUser user =(SessionUser) httpSession.getAttribute("user");
//        if(user != null){
//            model.addAttribute("userName",user.getName());
//        }
//        return "health";
//    }
//
//    //science
//    @GetMapping("/science")
//    public String scienceNews(Model model) throws JsonProcessingException {
//        model.addAttribute("news", newsApiService.newsScience());
//        model.addAttribute("comment", commentService.commentGet("science"));
//        model.addAttribute("category","science");
//        SessionUser user =(SessionUser) httpSession.getAttribute("user");
//        if(user != null){
//            model.addAttribute("userName",user.getName());
//        }
//        return "science";
//    }
//
//    //sports
//    @GetMapping("/sports")
//    public String sportsNews(Model model) throws JsonProcessingException {
//        model.addAttribute("news", newsApiService.newsSports());
//        model.addAttribute("comment", commentService.commentGet("sports"));
//        model.addAttribute("category","sports");
//        SessionUser user =(SessionUser) httpSession.getAttribute("user");
//        if(user != null){
//            model.addAttribute("userName",user.getName());
//        }
//        return "sports";
//    }
//
//    //technology
//    @GetMapping("/technology")
//    public String technologyNews(Model model) throws JsonProcessingException {
//        model.addAttribute("news", newsApiService.newsTechnology());
//        model.addAttribute("comment", commentService.commentGet("technology"));
//        model.addAttribute("category","technology");
//        SessionUser user =(SessionUser) httpSession.getAttribute("user");
//        if(user != null){
//            model.addAttribute("userName",user.getName());
//        }
//        return "technology";
//    }


}
