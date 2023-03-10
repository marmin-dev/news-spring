package com.multi.news.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Arrays;

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
    public NewDto toNewDto(NewsResponseDto dto){
        return NewDto.builder()
                .author(dto.getAuthor())
                .title(dto.getTitle())
                .url(dto.getUrl())
                .publishedAt(dto.getPublishedAt())
                .oid(getKey(url))
                .build();
    }

}
