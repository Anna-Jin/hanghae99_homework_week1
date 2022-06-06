package com.homework.homework.restController;

import com.homework.homework.dto.CommentDto;
import com.homework.homework.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentRestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommentService commentService;


//    @GetMapping("/{postId}")
//    public List<CommentDto>


    /**
     * 댓글 생성
     * @param commentDto
     * @return
     */
    @PostMapping("/{postId}/newcomment")
    public Map<String, Object> addComment(
            @PathVariable Long postId,
            @RequestBody CommentDto commentDto) {
        Map<String, Object> result = new HashMap<>();

        Long id = commentService.addComment(postId, commentDto);

        if (id != null) {
            result.put("result", "댓글 생성 성공");
        } else {
            result.put("result", "댓글 등록에 실패했습니다. 관리자에게 문의해주세요");
            logger.error("[comment] 댓글 등록 id : {}", postId);
        }

        return result;
    }

    /**
     * 댓글 수정
     * @param postId
     * @param commentId
     * @param commentDto
     * @return
     */
    @PutMapping("/{postId}/{commentId}")
    public Map<String, Object> updateComment(
            @PathVariable Long postId,
            @PathVariable Long commentId,
            @RequestBody CommentDto commentDto
    ) {
        Map<String, Object> result = new HashMap<>();

        Long id = commentService.updateComment(postId, commentId, commentDto);

        if (id != null) {
            result.put("result", "댓글 수정 완료");
        } else {
            result.put("result", "댓글 수정에 실패했습니다. 관리자에게 문의해주세요.");
            logger.error("[comment] 댓글 수정 postId: {}, commentId : {}", postId, commentId);
        }

        return result;
    }

}
