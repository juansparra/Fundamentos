package com.fundamentosplazi.springboot.fundamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundamentosplazi.springboot.fundamentos.entity.Post;

@Repository
public interface PostRepository  extends JpaRepository <Post, Long>{

}
