package com.loopcreations.blog_planet.service;

import com.loopcreations.blog_planet.model.Blog;
import com.loopcreations.blog_planet.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    private String getCurrentDateAndTime(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return LocalDateTime.now().format(dateTimeFormatter);
    }


    //get all blogs
    public List<Blog> getBlogs(){
        return blogRepository.findAll();
    }

    //create blog
    public String createBlog(Blog blog){
        blog.setPublishedDate(getCurrentDateAndTime());
        blogRepository.save(blog);
        return "Blog created successfully";
    }

    //get blog by id
    public Optional<Blog> getBlogById(Long blogId) {
        try {
            return blogRepository.findById(blogId);
        }catch (Exception e){
            throw new RuntimeException("Id not found" + e.getMessage());
        }
    }

    //update blog
    public String updateBlog(Long blogId, Blog blog){
        if(blogRepository.findById(blogId).isPresent()){
            blog.setId(blogId);
            blog.setPublishedDate(getCurrentDateAndTime());
            blogRepository.save(blog);
            return "Blog updated successfully";
        }else{
            return "Blog not found with id " + blogId;
        }
    }

    //delete blog
    public String deleteBlog(Long blogId){
        if(blogRepository.findById(blogId).isPresent()){
            blogRepository.deleteById(blogId);
            return "Blog deleted successfully";
        }else{
            return "Blog not found with id " + blogId;
        }
    }
}
