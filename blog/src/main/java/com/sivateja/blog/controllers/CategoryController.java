package com.sivateja.blog.controllers;

import com.sivateja.blog.domain.dtos.CategoryDto;
import com.sivateja.blog.domain.dtos.CreateCategoryRequest;
import com.sivateja.blog.domain.entities.Category;
import com.sivateja.blog.mappers.CategoryMapper;
import com.sivateja.blog.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories() {
        List<CategoryDto> categories = categoryService.listCategories().
                stream().map(categoryMapper::toDto)
                .toList();
        return ResponseEntity.ok(categories);


    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
            @Valid @RequestBody CreateCategoryRequest createCategoryRequest) {
        Category categoryToCreate=categoryMapper.toEntity(createCategoryRequest);
        Category savedCategory=categoryService.createCategory(categoryToCreate);
        return new ResponseEntity<>(
                categoryMapper.toDto(savedCategory),
                HttpStatus.CREATED);

    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deleteCCategory(@PathVariable UUID id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
