package com.dev.strangerred.repository;

import com.dev.strangerred.model.Comment;
import com.dev.strangerred.model.Post;
import com.dev.strangerred.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
