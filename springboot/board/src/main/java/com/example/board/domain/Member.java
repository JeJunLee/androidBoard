package com.example.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    @Column(name = "MEMBER_PW")
    private String password;

    @Column(name = "MEMBER_MAJOR")
    private Boolean major;

    @Column(name = "MEMBER_NAME")
    private String name;

}