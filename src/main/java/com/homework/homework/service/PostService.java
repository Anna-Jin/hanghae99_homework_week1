package com.homework.homework.service;

import com.homework.homework.domain.Post;
import com.homework.homework.dto.PostDto;
import com.homework.homework.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public List<Post> getPosts() {
        List<Post> posts = postRepository.findAll();
        return posts;
    }

    /**
     * 게시물 생성
     * @param postDto
     * @return
     */
    public Long addPost(PostDto postDto) {
        Post post = Post.builder()
                .title(postDto.getTitle())
                .nickname(postDto.getNickname())
                .content(postDto.getContent())
                .build();

        return postRepository.save(post).getId();
    }

    /**
     * 게시물 수정
     * @param id
     * @param postDto
     * @return
     */
    public Long updatePost(Long id, PostDto postDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("존재하지 않는 아이디입니다."));

        post.update(postDto);

        return postRepository.save(post).getId();
    }

}
