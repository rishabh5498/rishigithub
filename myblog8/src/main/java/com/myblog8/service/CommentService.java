package com.myblog8.service;

import com.myblog8.payload.CommentDto;

public interface CommentService {


     CommentDto saveComment(CommentDto dto, long postId) ;


     void deleteCommentById(long postId);


     CommentDto updateCommentById(CommentDto commentDto, long id);
}
