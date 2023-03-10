package com.multi.news.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multi.news.dtos.NewsResponseDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsApiService {
    String urlFr = "https://newsapi.org/v2/top-headlines?country=kr";
    String urlFrc = "https://newsapi.org/v2/top-headlines?country=kr&category=";
    @Value("${apiKey}")
    String apiKey;

    String[] categories = {"business","entertainment","health","science","sports","technology"};

    public String parsing(String data){
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj1 = (JSONObject) jsonParser.parse(data);
            JSONArray jsonObj2 = (JSONArray) jsonObj1.get("articles");
            return jsonObj2.toJSONString();
        }catch (ParseException e){
            e.printStackTrace();
            return "error";
        }
    }
    public List<NewsResponseDto> getData(String data) throws JsonProcessingException {
//        System.out.println(data);
        ObjectMapper obj = new ObjectMapper();
        obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<NewsResponseDto> newsList = obj.readValue(data, new TypeReference<List<NewsResponseDto>>() {});
        return newsList;
    }
    public String getRestTemplate(String url){
        RestTemplate restTemplate = new RestTemplate();
        String data = restTemplate.getForObject(url, String.class);
        return data;
    }
    // top headlines
    public List<NewsResponseDto> newsAll() throws JsonProcessingException {
        String url = urlFr + apiKey;
        String data = getRestTemplate(url);
        String data1 = parsing(data);
        List<NewsResponseDto> dtos = getData(data1);
        return dtos;
    }
    // category business
    public List<NewsResponseDto> newsBusiness() throws JsonProcessingException {
        String url = urlFrc + categories[0] +apiKey;
        String data = getRestTemplate(url);
        String data1 = parsing(data);
        List<NewsResponseDto> dtos = getData(data1);
        return dtos;
    }
    // entertainment
    public List<NewsResponseDto> newsEntertainment() throws JsonProcessingException {
        String url = urlFrc + categories[1] +apiKey;
        String data = getRestTemplate(url);
        String data1 = parsing(data);
        List<NewsResponseDto> dtos = getData(data1);
        return dtos;
    }
    // health
    public List<NewsResponseDto> newsHealth() throws JsonProcessingException {
        String url = urlFrc + categories[2] +apiKey;
        String data = getRestTemplate(url);
        String data1 = parsing(data);
        List<NewsResponseDto> dtos = getData(data1);
        return dtos;
    }
    //science
    public List<NewsResponseDto> newsScience() throws JsonProcessingException {
        String url = urlFrc + categories[3] +apiKey;
        String data = getRestTemplate(url);
        String data1 = parsing(data);
        List<NewsResponseDto> dtos = getData(data1);
        return dtos;
    }
    //sports
    public List<NewsResponseDto> newsSports() throws JsonProcessingException {
        String url = urlFrc + categories[4] +apiKey;
        String data = getRestTemplate(url);
        String data1 = parsing(data);
        List<NewsResponseDto> dtos = getData(data1);
        return dtos;
    }

    //technology
    public List<NewsResponseDto> newsTechnology() throws JsonProcessingException {
        String url = urlFrc + categories[5] +apiKey;
        String data = getRestTemplate(url);
        String data1 = parsing(data);
        List<NewsResponseDto> dtos = getData(data1);
        return dtos;
    }

}


