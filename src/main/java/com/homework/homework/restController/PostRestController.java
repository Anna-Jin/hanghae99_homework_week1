package com.homework.homework.restController;

import com.homework.homework.dto.PostDto;
import com.homework.homework.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostRestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String getPosts() {

        // service 연결

        return "posts/board";
    }


    /**
     * 게시물 생성
     * @param postDto
     * @return
     */
    @PostMapping("/newpost")
    public Map<String, Object> addPost(@RequestBody PostDto postDto) {
        Map<String, Object> result = new HashMap<>();

        // service 연결
        Long postId = postService.addPost(postDto);

        if (postId != null) {
            result.put("result", "게시물 생성 완료");
        } else {
            result.put("result", "게시물 등록에 실패했습니다. 관리자에게 문의해주세요.");
        }
        return result;
    }

    /**
     * 게시물 수정
     * @param id
     * @param postDto
     * @return
     */
    @PostMapping("/newpost/{id}")
    public Map<String, Object> updatePost(
            @PathVariable Long id,
            @RequestBody PostDto postDto) {
        Map<String, Object> result = new HashMap<>();

        Long postId = postService.updatePost(id, postDto);

        if (postId != null) {
            result.put("result", "게시물 수정 완료");
        } else {
            result.put("result", "게시물 수정에 실패했습니다. 관리자에게 문의해주세요.");
        }

        return result;
    }
}
