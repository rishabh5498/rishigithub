package com.myblog8.service.impl;

import com.myblog8.entity.Comment;
import com.myblog8.entity.Post;
import com.myblog8.exception.ResourceNotFound;
import com.myblog8.payload.CommentDto;
import com.myblog8.repository.CommentRepository;
import com.myblog8.repository.PostRepository;
import com.myblog8.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
        @Autowired
       private CommentRepository commentRepository;
       @Autowired
       private PostRepository postRepository;

@Autowired
  private ModelMapper modelMapper;
@Override
    public CommentDto saveComment(CommentDto dto, long postId) {

            Post post = postRepository.findById(postId).orElseThrow(

                    ()->new ResourceNotFound("post not found with id:"+postId)
            );
      //   Comment comment = new Comment();

        // comment.setId(dto.getId());
         //comment.setName(dto.getName());
         //comment.setEmail(dto.getEmail());
         //comment.setBody(dto.getBody());
         //comment.setPost(post);
    Comment comment = mapToComment(dto);
    comment.setPost(post);
              Comment savedcomment= commentRepository.save(comment);


                          CommentDto commentDto =new CommentDto();

                            commentDto.setId(savedcomment.getId());
                            commentDto.setName(savedcomment.getName());
                            commentDto.setEmail(savedcomment.getEmail());
                            commentDto.setBody(savedcomment.getBody());


        return commentDto;
    }


    @Override
    public void deleteCommentById(long postId) {
               commentRepository.deleteById(postId);
    }

    @Override
    public CommentDto updateCommentById(CommentDto commentDto, long id) {
    Comment comment = commentRepository.findById(id).orElseThrow(

            ()-> new ResourceNotFound("Comment not found for id:"+id)
    );
      comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
      comment.setBody(commentDto.getBody());


      Comment savedComment = commentRepository.save(comment);

      CommentDto dto = new CommentDto();
      dto.setId(savedComment.getId());
      dto.setName(savedComment.getName());
      dto.setEmail(savedComment.getEmail());
      dto.setBody(savedComment.getBody());
      return dto;
}

       public  Comment mapToComment(CommentDto dto){

      Comment comment =  modelMapper.map(dto,Comment.class);
         //  Comment comment = new Comment();
           //comment.setId(dto.getId());
           //comment.setName(dto.getName());
           //comment.setEmail(dto.getEmail());
           //comment.setBody(dto.getBody());
           return comment;
       }
}









