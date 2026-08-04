package io.github.marcelosrg.movieflix.mapper;

import io.github.marcelosrg.movieflix.dtos.request.CategoryRequest;
import io.github.marcelosrg.movieflix.dtos.response.CategoryResponse;
import io.github.marcelosrg.movieflix.entity.Category;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryMapper {

    public Category toCategory(CategoryRequest categoryRequest){
        Category category = new Category();
        category.setName(categoryRequest.name());

        return category;
    }

    public CategoryResponse toResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName());
    }

    public List<CategoryResponse> toResponseList(List<Category> categories) {
        return categories.stream()
                .map(this::toResponse)
                .toList();
    }



}
