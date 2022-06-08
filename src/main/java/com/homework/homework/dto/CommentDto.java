package com.homework.homework.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class CommentDto {
    private String nickname;

    @NotEmpty
    private String comment;
}
