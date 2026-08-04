package io.github.marcelosrg.movieflix.contorller;

import io.github.marcelosrg.movieflix.dtos.request.CategoryRequest;
import io.github.marcelosrg.movieflix.dtos.response.CategoryResponse;
import io.github.marcelosrg.movieflix.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/movieflix/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findCategoryById(@PathVariable() UUID id) {
        CategoryResponse category = categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }

    @GetMapping
    public List<CategoryResponse> getAllCategories() {
        return categoryService.findAll();
    }


    @PostMapping()
    public CategoryResponse createCategory(@RequestBody CategoryRequest request) {
        return categoryService.createCategory(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable() UUID id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Categoria deletada com sucesso!");
    }



}
