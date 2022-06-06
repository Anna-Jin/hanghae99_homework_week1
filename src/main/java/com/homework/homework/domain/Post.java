package com.homework.homework.domain;

import com.homework.homework.dto.PostDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    @Builder
    public Post(String title, String nickname, String content) {
        this.title = title;
        this.nickname = nickname;
        this.content = content;
    }

    public void update(PostDto postDto) {
        this.title = postDto.getTitle();
        this.nickname = postDto.getNickname();
        this.content = postDto.getContent();
    }

}
