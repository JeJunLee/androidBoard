package com.example.homework.dto;

import com.example.homework.domain.Post;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostPatchFormDto {
    private String password;
    private Post post;
}
