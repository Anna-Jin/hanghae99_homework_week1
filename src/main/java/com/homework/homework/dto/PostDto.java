package com.homework.homework.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDto {

    private Long id;
    private String title;
    private String nickname;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
