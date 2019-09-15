package com.example.jwtspring.service;

import com.example.jwtspring.model.Category;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategories();

    Optional<Category> getCategoryById(Long id);

    Category createCategory(String name);

    void updateCategory(Category category, String name);

    void deleteCategory(Category category);

    boolean isChildCategory(Category child, Category parent);

    void addChildCategory(Category child, Category parent);

    void removeChildCategory(Category child, Category parent);
}
