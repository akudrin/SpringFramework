package com.apress.demospringboot3ch4.service;

import com.apress.demospringboot3ch4.domain.Post;
import com.apress.demospringboot3ch4.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    public void addPost(Post post) {
        postRepository.addPost(post);
    }
    public Set<Post> findAllPosts() {
        return postRepository.findAllPosts();
    }

    public boolean postExistsWithTitle(String title) {
        return postRepository.findAllPosts().stream()
                .anyMatch(post -> post.getTitle().equals(title));
    }
}