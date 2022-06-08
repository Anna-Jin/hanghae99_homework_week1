package com.homework.homework.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class PostResponseDto {
    private Long id;
    private String title;
    private String nickname;
    private String content;
    private LocalDateTime createdAt;
}
