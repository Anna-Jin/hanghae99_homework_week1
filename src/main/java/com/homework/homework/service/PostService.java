package com.homework.homework.service;

import com.homework.homework.domain.Post;
import com.homework.homework.dto.PostDto;
import com.homework.homework.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Long addPost(PostDto postDto) {
        Post post = new Post(postDto.getTitle(), postDto.getContent());
        return postRepository.save(post).getId();
    }

}
