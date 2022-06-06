package com.homework.homework.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@Builder @AllArgsConstructor
@NoArgsConstructor
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @NonNull
    private Post post;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String comment;

    private void update(String nickname, String comment) {
        this.nickname = nickname;
        this.comment = comment;
    }
}
