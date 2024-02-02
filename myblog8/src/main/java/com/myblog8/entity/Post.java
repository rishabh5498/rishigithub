package com.myblog8.entity;


import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;

@Entity
@Table(name="post")

@Data
public class Post {

                 @Id
                 @GeneratedValue(strategy = GenerationType.IDENTITY)
                private Long id;
@Column(name="title",nullable = false)
                private String title;
    @Column(name="description",nullable = false)
                private String description;
    @Column(name="content",nullable = false)
                private String content;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
                   private Set<Comment> comments = new HashSet<>();


    private Object posts;
}