package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CommentRepo;
import com.app.dao.PostRepo;
import com.app.dto.CommentDto;
import com.app.exc_handler.ResourceNotFoundException;
import com.app.pojos.Comment;
import com.app.pojos.Post;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostRepo postRepo;
    
    @Autowired
    private CommentRepo commentRepo;
    
    @Autowired
    private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post","post id", postId));
		Comment comment=this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
	Comment savedComment=	this.commentRepo.save(comment);
		return this.modelMapper.map(comment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
	 Comment comment= this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("comment","comment id", commentId));
this.commentRepo.delete(comment);
	}

}
