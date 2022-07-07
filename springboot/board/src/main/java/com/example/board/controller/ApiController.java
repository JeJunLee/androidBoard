package com.example.board.controller;

import com.example.board.domain.Member;
import com.example.board.domain.Post;
import com.example.board.repository.MemberRepository;
import com.example.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/login")
    public Boolean posts(@RequestParam(value = "id" , required = false)String id,
                        @RequestParam(value = "password" , required = false)String password
                        ){

        if ( memberRepository.findById(id).isPresent() ){
            Member member = memberRepository.findById(id).get();
            if ( member.getPassword().equals(password) ){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @PostMapping("/post")
    public Boolean post(@RequestBody Post post){
        System.out.println("post = " + post);

        post.setCreated( LocalDateTime.now()  );

        postRepository.save(post);

        return true;
    }

    @DeleteMapping("/post")
    public Boolean deletePost(@RequestParam(value = "postId", required = false) String postId){

        postRepository.deleteById(Long.valueOf(postId));

        return true;
    }

    @PatchMapping("/post")
    public Boolean upViews(@RequestParam(value = "memberId") String memberId,
                           @RequestParam(value = "postId") Long postId){

        Post post = postRepository.findById(postId).get();

        if (memberRepository.findById(memberId).isPresent()){
            if ( memberRepository.findById(memberId).get().getMajor() ){
                post.setMajorViews( post.getMajorViews() + 1 );
            }else{
                post.setViews( post.getViews() + 1 );
            }
        }else{
            post.setViews( post.getViews() + 1 );
        }

        postRepository.save(post);

        return true;
    }

    @PatchMapping("/post/good/{postId}")
    public Boolean upGoods( @PathVariable("postId") String postId ){

        Post post = postRepository.findById(Long.valueOf(postId)).get();

        post.setGoods( post.getGoods()+1 );

        postRepository.save(post);


        return true;

    }



}
