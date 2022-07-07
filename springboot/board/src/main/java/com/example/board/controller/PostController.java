package com.example.board.controller;

import com.example.board.domain.Post;
import com.example.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;

    @GetMapping("/")
    public String login(){

        return "login";
    }

    @GetMapping("/posts")
    public String posts(Model model){

        List<Post> postList = postRepository.findAll();
        model.addAttribute("postList", postList);

        return "post_list";
    }

    @GetMapping("/post")
    public String postCreatePage(){

        return "post_create";
    }

    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable("id")Long id,
                           Model model){
        Post post =  postRepository.findById(id).get();
        model.addAttribute("post", post);

        return "post_detail";
    }



}
