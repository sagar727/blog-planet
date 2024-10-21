package com.loopcreations.blog_planet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="blog")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "blogTitle", nullable = false, length = 200)
    private String blogTitle;

    @Column(name = "blogDetails", nullable = false, length = 1000)
    private String blogDetails;

    @Column(name = "topic", nullable = false)
    private String topic;

    private String authorName;

    private String publishedDate;

}
