package com.homework.homework.repository;

import com.homework.homework.domain.Comment;
import com.homework.homework.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findCommentByPostIdAndId(Long postId, Long id);

    List<Comment> findCommentsByPost(Post post);
}
