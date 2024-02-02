package com.myblog8.controller;

import com.myblog8.payload.CommentDto;

import com.myblog8.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
     @Autowired
    private CommentService commentService;
  //http://localhost:8080/api/comments/{postid}
     @PostMapping("{postId}")
    public ResponseEntity<CommentDto> saveComment(@RequestBody CommentDto commentDto, @PathVariable long postId) {
        CommentDto dto = commentService.saveComment(commentDto, postId);
        return  new ResponseEntity<>(dto,HttpStatus.OK);
     }

             @DeleteMapping("{postId}")   //Http://localhost:8080/api/comments/
         public  ResponseEntity<String> deleteCommentById(@PathVariable long postId ){
         commentService.deleteCommentById(postId);
         return  new ResponseEntity<>("Comment is deleted with id:"+postId,HttpStatus.OK);
             }

    @PutMapping("{id}")   //Http://localhost:8080/api/comments/
    public  ResponseEntity<CommentDto> updateCommentById( @RequestBody CommentDto commentDto, @PathVariable long id ){
        CommentDto dto = commentService.updateCommentById(commentDto,id);
        return  new ResponseEntity<>(dto,HttpStatus.OK);
    }
   //Http://localhost:8080/api/comments/id
}
//getmapping remaining




