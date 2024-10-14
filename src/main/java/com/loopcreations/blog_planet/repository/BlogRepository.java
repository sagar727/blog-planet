package com.loopcreations.blog_planet.repository;

import com.loopcreations.blog_planet.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {

}
