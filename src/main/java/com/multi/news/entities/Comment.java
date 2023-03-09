package com.multi.news.entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "Comment")
@Builder
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String content;

    @NotNull
    private String author;

    private String post;
}
