package com.multi.news.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NewDto {
    private String author;

    private String title;

    private String url;

    private String publishedAt;

    private String oid;



}
