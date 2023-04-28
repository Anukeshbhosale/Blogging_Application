package com.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
private Integer categoryId;

@NotBlank
@Size(min = 4,message="Min size of category title is 4")
private String categoryTitle;
@NotBlank
@Size(min= 10, message="min size of category dsec is 10")
private String categoryDescription;

}
