package com.example.homework.repository;


import com.example.homework.domain.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Modifying
    @Transactional
    @Query("update Post p set p.views = p.views + 1 where p.id = :id")
    void updateView(Long id);

    List<Post> findByNameContaining(String name, Sort by);

}
