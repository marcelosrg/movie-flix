package io.github.marcelosrg.movieflix.service;

import io.github.marcelosrg.movieflix.entity.Category;
import io.github.marcelosrg.movieflix.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
}
