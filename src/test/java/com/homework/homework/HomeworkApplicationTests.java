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
import java.util.List;

@SpringBootTest
class HomeworkApplicationTests {
    
    @Autowired
    private PostService postService;
    
    @Autowired
    private PostRepository postRepository;

    @Test
    @Transactional
    void getPostTest() {
        List<Post> posts = postRepository.findAll();

    }

}
