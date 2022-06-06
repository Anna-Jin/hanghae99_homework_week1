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

    /**
     * 게시물 조회
     * @return
     */
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
     * @param postId
     * @param postDto
     * @return
     */
    public Long updatePost(Long postId, PostDto postDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NullPointerException("존재하지 않는 게시글입니다."));

        post.update(postDto);

        return postRepository.save(post).getId();
    }


    /**
     * 게시물 삭제
     * @param postId
     */
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

}
