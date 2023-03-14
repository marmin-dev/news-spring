package com.multi.news.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsResponseDto {
    private String author;

    private String title;

    private String url;

    private String publishedAt;

    public String getKey(String url){
        String[] str1 = url.split("/");
        return str1[5];
    }

}
