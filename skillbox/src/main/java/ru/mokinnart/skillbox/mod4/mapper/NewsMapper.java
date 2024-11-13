package ru.mokinnart.skillbox.mod4.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.mokinnart.skillbox.mod4.dto.NewsDTO;
import ru.mokinnart.skillbox.mod4.model.News;

@Mapper(componentModel = "spring")
public interface NewsMapper {
    @Mapping(target = "author", source = "author.username")
    @Mapping(target = "category", source = "category.name")
    NewsDTO toDto(News news);
    @Mapping(target = "author.username", source = "author")
    @Mapping(target = "category.name", source = "category")
    News toEntity(NewsDTO newsDTO);
}