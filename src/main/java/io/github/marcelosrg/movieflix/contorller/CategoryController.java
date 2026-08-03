package io.github.marcelosrg.movieflix.contorller;

import io.github.marcelosrg.movieflix.entity.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/movieflix/category")
public class CategoryController {

    public List<Category> getAllCategories() {

    }
}
