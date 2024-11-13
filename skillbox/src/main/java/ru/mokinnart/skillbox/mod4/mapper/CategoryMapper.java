package ru.mokinnart.skillbox.mod4.mapper;
import org.mapstruct.Mapper;

import ru.mokinnart.skillbox.mod4.dto.CategoryDTO;
import ru.mokinnart.skillbox.mod4.model.Category;
    
@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDto(Category category);
    Category toEntity(CategoryDTO categoryDTO);
}