package com.apress.demospringboot3ch4.controller;

import com.apress.demospringboot3ch4.domain.Post;
import com.apress.demospringboot3ch4.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    //private final PostRepository postRepository;
    @GetMapping
    public String postPage(Model model) {
        Post post = new Post();
        post.setTitle("Hello Spring Boot");
        post.setDescription("Spring Boot");
        post.setBody("Spring Boot is Awesome");
        //postRepository.addPost(post);
        Post post1 = new Post();
        post1.setTitle("Hello Spring Boot 3");
        post1.setDescription("Spring Boot 3");
        post1.setBody("Spring Boot 3 is Awesome");
        //postRepository.addPost(post1);
        model.addAttribute("posts", postService.findAllPosts());
        return "post";
    }

    @GetMapping("/add")
    public String addPostPage(Model model) {
        model.addAttribute("post", new Post());
        return "addPost";
    }
    @PostMapping
    public String addPost(@ModelAttribute("post") @Valid Post post, Errors
                          errors) {
        if(errors.hasErrors()){
            return "addPost";
        }
        postService.addPost(post);
        return "redirect:/posts";
    }
}