package com.homework.homework.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID", nullable = false)
    private Post post;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String comment;

    @Builder
    public Comment(Post post, String nickname, String comment) {
        this.post = post;
        this.nickname = nickname;
        this.comment = comment;
    }

    public void update(String nickname, String comment) {
        this.nickname = nickname;
        this.comment = comment;
    }
}
