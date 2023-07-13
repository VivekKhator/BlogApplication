package com.spring.blogapp.services;

import java.util.List;

import com.spring.blogapp.payloads.CategoryDto;

public interface CategoryService {
	
	List<CategoryDto> getAllCategories();
	CategoryDto getCategory(Integer categoryId);
	CategoryDto createCategory(CategoryDto categoryDto);
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	void deleteCategory(Integer categoryId);
}
