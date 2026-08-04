package io.github.marcelosrg.movieflix.service;

import io.github.marcelosrg.movieflix.entity.Category;
import io.github.marcelosrg.movieflix.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }


    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category findById(UUID id){
        return categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada!"));
    }

    public void deleteCategory(UUID id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada!"));
        categoryRepository.deleteById(id);
    }
}
