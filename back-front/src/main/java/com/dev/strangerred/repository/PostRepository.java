package com.dev.strangerred.repository;

import com.dev.strangerred.model.Post;
import com.dev.strangerred.model.Subreddit;
import com.dev.strangerred.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);
}
