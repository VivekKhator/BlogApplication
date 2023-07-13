package com.spring.blogapp.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.blogapp.entities.Category;
import com.spring.blogapp.exceptions.ResourceNotFoundException;
import com.spring.blogapp.payloads.CategoryDto;
import com.spring.blogapp.repositories.CategoryRepository;
import com.spring.blogapp.services.CategoryService;


@Service
public class CategoryServiecImpl implements CategoryService{

	@Autowired
	private CategoryRepository cateRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> cates = this.cateRepo.findAll();
		List<CategoryDto> cateDtos = cates.stream().map(cate -> categoryToDto(cate)).collect(Collectors.toList());
		return cateDtos;
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category category = this.cateRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
		return categoryToDto(category);
	}

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = this.cateRepo.save(this.modelMapper.map(categoryDto, Category.class));
//		Category category = this.cateRepo.save(dtoToCategory(categoryDto));
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category cate = this.cateRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
		cate.setCategoryTitle(categoryDto.getCategoryTitle());
		cate.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedCate = this.cateRepo.save(cate);
		return categoryToDto(updatedCate);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cate = this.cateRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
		this.cateRepo.delete(cate);
		return;
	}
	
	
	public CategoryDto categoryToDto(Category category) {
		CategoryDto cateDto = modelMapper.map(category, CategoryDto.class);
		return cateDto;
	}
	
	public Category dtoToCategory(CategoryDto categoryDto) {
		Category cate = modelMapper.map(categoryDto, Category.class);
		return cate;
	}
}
