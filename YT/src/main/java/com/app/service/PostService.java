package com.app.service;

import java.util.List;

import com.app.dto.PostDto;
import com.app.dto.PostResponse;
import com.app.pojos.Post;

public interface PostService {
//create
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	
	//update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	
	//delete
	
	
	void deletePost(Integer postId);
	
	//get all posts
	
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String SortBy, String sortDir);
	
	//get single post
	
	PostDto getPostById(Integer postId);
	
	//get all post by category
	
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	
	//get All posts by user
	List<PostDto> getPostByUser(Integer userId);

	//search posts
	List<PostDto> searchPosts(String keyword);
	
}
