package com.homework.homework.service;

import com.homework.homework.domain.Comment;
import com.homework.homework.domain.Post;
import com.homework.homework.dto.CommentDto;
import com.homework.homework.repository.CommentRepository;
import com.homework.homework.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    /**
     * 댓글 조회
     * @param postId
     * @return
     */
    public List<Comment> getComments(Long postId) {
        return commentRepository.findCommentsByPostId(postId);
    }

    /**
     * 댓글 생성
     * @param commentDto
     * @return
     */
    public Long addComment(Long postId, CommentDto commentDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NullPointerException("해당 게시글이 존재하지 않습니다." + postId)); // 어차피 postId가 not null이라 예외처리가 필요없을거 같긴 한데?

        Comment comment = Comment.builder()
                .post(post)
                .nickname(commentDto.getNickname())
                .comment(commentDto.getComment())
                .build();

        return commentRepository.save(comment).getId();
    }

    /**
     * 댓글 수정
     * @param commentId
     * @param commentDto
     * @return
     */
    public Long updateComment(Long commentId, CommentDto commentDto) {
//        Post post = postRepository.findById(postId).orElseThrow(() -> new NullPointerException("해당 게시물이 존재하지 않습니다."));

        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("해당 댓글이 존재하지 않습니다."));
        comment.update(commentDto);

        return commentRepository.save(comment).getId();
    }

    /**
     * 댓글 삭제
     * @param commentId
     */
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
