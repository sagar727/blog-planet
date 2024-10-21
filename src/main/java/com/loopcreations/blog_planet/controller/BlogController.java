package com.loopcreations.blog_planet.controller;


import com.loopcreations.blog_planet.model.Blog;
import com.loopcreations.blog_planet.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> getBlogs(){
        List<Blog> blogs = blogService.getBlogs();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("id/{blogId}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long blogId){
        Optional<Blog> blog = blogService.getBlogById(blogId);
        return blog.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/createBlog")
    public String createBlog(@RequestBody Blog blog){
        return blogService.createBlog(blog);
    }

    @PutMapping("/updateBlog/id/{blogId}")
    public String updateBlog(@PathVariable Long blogId, @RequestBody Blog blog){
        return blogService.updateBlog(blogId,blog);
    }

    @DeleteMapping("/deleteBlog/id/{blogId}")
    public String deleteBlog(@PathVariable Long blogId){
        return blogService.deleteBlog(blogId);
    }

}
