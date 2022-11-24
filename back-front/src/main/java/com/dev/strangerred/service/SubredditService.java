package com.dev.strangerred.service;

import com.dev.strangerred.mapper.SubredditMapper;
import com.dev.strangerred.model.Subreddit;
import com.dev.strangerred.dto.SubredditDto;
import com.dev.strangerred.exceptions.SpringRedditException;
import com.dev.strangerred.model.User;
import com.dev.strangerred.repository.SubredditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class SubredditService {

    private final SubredditRepository subredditRepository;

    private final SubredditMapper subredditMapper;

    private final AuthService authService;

    @Transactional
    public SubredditDto save(SubredditDto subredditDto) {
        User user = authService.getCurrentUser();
        Subreddit save = subredditRepository.save(subredditMapper.mapDtoToSubreddit(subredditDto));
        save.setCreatedDate(Instant.now());
        save.setUser(user);
        subredditDto.setId(save.getId());
        return subredditDto;
    }

    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
        return subredditRepository.findAll()
                .stream()
                .map(subredditMapper::mapSubredditToDto)
                .collect(toList());
    }

    @Transactional
    public SubredditDto getSubreddit(Long id) {
        Subreddit subreddit = subredditRepository.findById(id)
                .orElseThrow(() -> new SpringRedditException("No subreddit found with ID - " + id));
        return subredditMapper.mapSubredditToDto(subreddit);
    }
}
