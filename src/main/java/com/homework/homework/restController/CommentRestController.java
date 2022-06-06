package com.homework.homework.restController;

import com.homework.homework.domain.Comment;
import com.homework.homework.dto.CommentDto;
import com.homework.homework.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comments")
@Slf4j
public class CommentRestController {

    @Autowired
    private CommentService commentService;

    /**
     * 댓글 목록 조회
     * @param postId
     * @return
     */
    @GetMapping("/{postId}")
    public List<Comment> getComments(
            @PathVariable Long postId
    ) {
        List<Comment> comments = commentService.getComments(postId);

        return comments;
    }


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
            log.error("[comment] 댓글 등록 id : {}", postId);
        }

        return result;
    }

    /**
     * 댓글 수정
     * @param commentId
     * @param commentDto
     * @return
     */
    @PutMapping("/{commentId}")
    public Map<String, Object> updateComment(
            @PathVariable Long commentId,
            @RequestBody CommentDto commentDto
    ) {
        Map<String, Object> result = new HashMap<>();

        Long id = commentService.updateComment(commentId, commentDto);

        if (id != null) {
            result.put("result", "댓글 수정 완료");
        } else {
            result.put("result", "댓글 수정에 실패했습니다. 관리자에게 문의해주세요.");
            log.error("[comment] 댓글 수정 commentId : {}", commentId);
        }

        return result;
    }

    /**
     * 댓글 삭제
     * @param commentId
     * @return
     */
    @DeleteMapping("/{commentId}")
    public String deleteComment(
            @PathVariable Long commentId
    ) {
        commentService.deleteComment(commentId);
        log.info("[comment] 댓글 삭제 id : {}", commentId);

        return "댓글 삭제 완료";
    }

}
