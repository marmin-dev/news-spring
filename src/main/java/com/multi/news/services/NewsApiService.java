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


import java.util.List;


@Service
public class NewsApiService {
    String urlFr = "https://newsapi.org/v2/top-headlines?country=kr";
    String urlFrc = "https://newsapi.org/v2/top-headlines?country=kr&category=";
    @Value("${apiKey}")
    String apiKey;

    String[] categories = {"business","entertainment","health","science","sports","technology"};

    // Json 문자열 파싱
    public String parsing(String data){
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj1 = (JSONObject) jsonParser.parse(data);
            JSONArray jsonObj2 = (JSONArray) jsonObj1.get("articles");
            // articles 만 추출한 데이터 String 타입으로 내보냄
            return jsonObj2.toJSONString();
        }catch (ParseException e){
            e.printStackTrace();
            return "error";
        }
    }
    // 데이터 가져오기
    public List<NewsResponseDto> getData(String data) throws JsonProcessingException {
//        System.out.println(data);
        ObjectMapper obj = new ObjectMapper();
        // 오브젝트에서 원하는 값만 추출 가능하도록 설정함
        obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 뉴스리스트는 오브젝트와 dto에서 서로 값이 같은 오브젝트 가져옴
        List<NewsResponseDto> newsList = obj.readValue(data, new TypeReference<List<NewsResponseDto>>() {});
        // List 타입으로 Dto로 내보내기
        return newsList;
    }
    // restTemplate으로 주소에서 Json데이터 가져오기
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


