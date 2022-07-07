package com.example.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Post {

    @Id
    @Column(name = "POST_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "POST_TITLE")
    private String title;

    @Column(name = "POST_CONTENT")
    private String content;

    @Column(name = "POST_VIEWS")
    private int views;

    @Column(name = "POST_MAJOR_VIEWS")
    private int majorViews;

    @Column(name = "POST_CREATED")
    private LocalDateTime created;

    @Column(name = "POST_GOODS")
    private int goods;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

}
