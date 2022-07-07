package com.example.homework.controller;

import com.example.homework.domain.Post;
import com.example.homework.dto.PostPatchFormDto;
import com.example.homework.dto.ResponseDto;
import com.example.homework.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {

    private final PostRepository postRepository;

    @GetMapping("/")
    public List<Post> getPosts(@RequestParam(value = "sort", required = false ,defaultValue = "created" )String sort,
                               @RequestParam(value = "search", required = false, defaultValue = "")String search ){

        System.out.println(search);
        List<Post> posts = postRepository.findByNameContaining(search, Sort.by(Sort.Direction.DESC, sort));
        return posts;
    }

    @GetMapping("/{postId}")
    public Post getPost(@PathVariable("postId")Long postId){
        postRepository.updateView(postId);
        Optional<Post> post= postRepository.findById(postId);
        System.out.println("post.get() = " + post.get());
        return post.get();
    }

    @PostMapping("/")
    public ResponseDto addPost(@RequestBody Post post){
        //DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        post.setCreated(LocalDateTime.now().toString());
        postRepository.save(post);
        return new ResponseDto("성공");
    }

    @PatchMapping("/")
    public ResponseDto patchPost(@RequestBody PostPatchFormDto postPatchFormDto){

        String postPassword = postRepository.findById(postPatchFormDto.getPost().getId()).get().getPassword();
        System.out.println("postPassword = " + postPassword);
        System.out.println("postPatchFormDto = " + postPatchFormDto.toString());

        if (postPatchFormDto.getPassword().equals(postPassword)){

            postRepository.save(postPatchFormDto.getPost());

            return new ResponseDto("성공");
        }else{

            return new ResponseDto("실패");
        }
    }

    @DeleteMapping("/")
    public ResponseDto deletePost(@RequestParam("postId") Long postId, @RequestParam("password")String inputPassword){

        System.out.println("postId = " + postId);
        System.out.println("inputPassword = " + inputPassword);
        Optional<Post> post = postRepository.findById(postId);
        if (post.get().getPassword().equals(inputPassword)){
            postRepository.deleteById(post.get().getId());

            return new ResponseDto("성공");
        }else {
            return new ResponseDto("실패");
        }
    }

}
