package com.app.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.app.pojos.Category;
import com.app.pojos.Comment;
import com.app.pojos.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	private Integer postId;

	private String title;
	private String content;
	
	
	private String imageName;
	@CreationTimestamp
	private Date addedDate;
	
	private CategoryDto category;
	
	
	private UserDto user;
	
	private Set<CommentDto>  comments=new HashSet<>();
	
}
