package ru.mokinnart.skillbox.mod4.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.mokinnart.skillbox.mod4.dto.CategoryDTO;
import ru.mokinnart.skillbox.mod4.mapper.CategoryMapper;
import ru.mokinnart.skillbox.mod4.repository.CategoryRepository;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        var category = categoryMapper.toEntity(categoryDTO);
        category = categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        var category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(categoryDTO.getName());
        category = categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }
    // Удалить категорию
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}