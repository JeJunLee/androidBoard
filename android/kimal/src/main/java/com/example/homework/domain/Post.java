package com.example.homework.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@SequenceGenerator(
        name = "POST_SEQ_GENERATOR",
        sequenceName = "POST_SEQ",
        initialValue = 1, allocationSize = 1
)

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_SEQ_GENERATOR")
    @Column(name = "POST_ID")
    private Long id;

    @Column(name = "POST_NAME")
    private String name;

    @Column(name = "POST_CREATED")
    private String created;

    @Column(name = "POST_PASSWORD")
    private String password;

    @Column(name = "POST_VIEWS")
    private int views;

    @Column(name = "POST_CONTENT")
    private String content;



}
