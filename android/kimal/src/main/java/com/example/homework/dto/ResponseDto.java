package com.example.homework.dto;

import com.example.homework.domain.Post;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseDto {
    private String response;

    public ResponseDto(String response){
        this.response = response;
    }
}


