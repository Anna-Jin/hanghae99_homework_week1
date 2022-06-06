package com.homework.homework.restController;

import com.homework.homework.domain.Post;
import com.homework.homework.dto.PostDto;
import com.homework.homework.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostRestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PostService postService;

    /**
     * 게시물 가져오기
     * @return
     */
    @GetMapping("")
    public List<Post> getPosts() {
        List<Post> postsList = postService.getPosts();

        return postsList;
    }

    /**
     * 게시물 생성
     * @param postDto
     * @return
     */
    @PostMapping("/newpost")
    public Map<String, Object> addPost(@RequestBody PostDto postDto) {
        Map<String, Object> result = new HashMap<>();

        Long id = postService.addPost(postDto);

        if (id != null) {
            result.put("result", "게시물 생성 완료");
        } else {
            result.put("result", "게시물 등록에 실패했습니다. 관리자에게 문의해주세요.");
            logger.error("[post] 게시물 등록");
        }
        return result;
    }

    /**
     * 게시물 수정
     * @param postId
     * @param postDto
     * @return
     */
    @PutMapping("/newpost/{postId}")
    public Map<String, Object> updatePost(
            @PathVariable Long postId,
            @RequestBody PostDto postDto) {
        Map<String, Object> result = new HashMap<>();

        Long id = postService.updatePost(postId, postDto);

        if (id != null) {
            result.put("result", "게시물 수정 완료");
        } else {
            result.put("result", "게시물 수정에 실패했습니다. 관리자에게 문의해주세요.");
            logger.error("[post] 게시물 수정 id: {}", id);
        }

        return result;
    }
}
