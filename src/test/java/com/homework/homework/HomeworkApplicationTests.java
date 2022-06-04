package com.homework.homework;

import com.homework.homework.domain.Post;
import com.homework.homework.dto.PostDto;
import com.homework.homework.repository.PostRepository;
import com.homework.homework.service.PostService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;

@SpringBootTest
class HomeworkApplicationTests {
    
    @Autowired
    private PostService postService;
    
    @Autowired
    private PostRepository postRepository;

    @Test
    @Transactional
    void save() {
        PostDto postDto = new PostDto();
        postDto.setTitle("안녕하세요");
        postDto.setContent("테스트입니다.");
        
        postService.addPost(postDto);

        Post post = postRepository.findById(1L).get();

        Assertions.assertThat(postDto.getTitle()).isEqualTo(post.getTitle());
    }

}
