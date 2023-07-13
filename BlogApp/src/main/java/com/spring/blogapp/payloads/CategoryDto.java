package com.spring.blogapp.payloads;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private Integer categoryId;
	
	@NotNull
	@Size(min=3, message="Title should be min of 3 chars and less than 12 chars")
	private String categoryTitle;
	
	@NotNull
	@Size(min=10, message="Description should be min of 10 chars and less than 100 chars")
	private String categoryDescription;
}
