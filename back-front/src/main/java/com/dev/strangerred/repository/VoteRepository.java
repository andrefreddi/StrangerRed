package com.dev.strangerred.repository;

import com.dev.strangerred.model.Post;
import com.dev.strangerred.model.User;
import com.dev.strangerred.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
