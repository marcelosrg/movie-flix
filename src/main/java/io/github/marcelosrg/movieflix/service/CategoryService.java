package io.github.marcelosrg.movieflix.service;

import io.github.marcelosrg.movieflix.dtos.request.CategoryRequest;
import io.github.marcelosrg.movieflix.dtos.response.CategoryResponse;
import io.github.marcelosrg.movieflix.entity.Category;
import io.github.marcelosrg.movieflix.exception.NotFoundException;
import io.github.marcelosrg.movieflix.mapper.CategoryMapper;
import io.github.marcelosrg.movieflix.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository,  CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }
    public List<CategoryResponse> findAll(){
        return categoryMapper.toResponseList( categoryRepository.findAll());
    }


    public CategoryResponse createCategory(CategoryRequest category){
        return categoryMapper.toResponse(categoryRepository.save(categoryMapper.toCategory(category)));
    }

    public CategoryResponse findById(UUID id){
        return categoryMapper.toResponse(categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Categoria não encontrada!")));
    }

    public void deleteCategory(UUID id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada!"));
        categoryRepository.deleteById(id);
    }
}
