package com.dev.strangerred.service;

import com.dev.strangerred.mapper.PostMapper;
import com.dev.strangerred.model.Post;
import com.dev.strangerred.model.Subreddit;
import com.dev.strangerred.model.User;
import com.dev.strangerred.dto.PostRequest;
import com.dev.strangerred.dto.PostResponse;
import com.dev.strangerred.exceptions.PostNotFoundException;
import com.dev.strangerred.exceptions.SubredditNotFoundException;
import com.dev.strangerred.repository.PostRepository;
import com.dev.strangerred.repository.SubredditRepository;
import com.dev.strangerred.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final SubredditRepository subredditRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final PostMapper postMapper;

    public void save(PostRequest postRequest) {
        Subreddit subreddit = subredditRepository.findByName(postRequest.getSubredditName()).orElseThrow(() -> new SubredditNotFoundException(postRequest.getSubredditName()));

        Post post = new Post();
        post.setPostId(postRequest.getPostId());
        post.setPostName(postRequest.getPostName());
        post.setUrl(postRequest.getUrl());
        post.setDescription(postRequest.getDescription());
        post.setVoteCount(0);
        post.setUser(authService.getCurrentUser());
        post.setCreatedDate(Instant.now());
        post.setSubreddit(subreddit);

        subreddit.getPosts().add(post);

        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll().stream().map(postMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsBySubreddit(Long subredditId) {
        Subreddit subreddit = subredditRepository.findById(subredditId)
                .orElseThrow(() -> new SubredditNotFoundException(subredditId.toString()));
        List<Post> posts = postRepository.findAllBySubreddit(subreddit);
        return posts.stream().map(postMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return postRepository.findByUser(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }
}
