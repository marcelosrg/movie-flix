package io.github.marcelosrg.movieflix.contorller;

import io.github.marcelosrg.movieflix.entity.Category;
import io.github.marcelosrg.movieflix.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movieflix/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @PostMapping()
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }
}
