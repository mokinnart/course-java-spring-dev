package ru.mokinnart.skillbox.mod5.service;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.mokinnart.skillbox.mod5.dto.BookDTO;
import ru.mokinnart.skillbox.mod5.mapper.BookMapper;
import ru.mokinnart.skillbox.mod5.model.Book;
import ru.mokinnart.skillbox.mod5.repository.BookRepository;
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    @Cacheable(value = "books", key = "#title + #author")
    public Optional<Book> findByTitleAndAuthor(String title, String author) {
        return bookRepository.findByTitleAndAuthor(title, author);
    }
    @Cacheable(value = "categories", key = "#categoryName")
    public List<Book> findByCategoryName(String categoryName) {
        return bookRepository.findByCategory_Name(categoryName);
    }
    @CacheEvict(value = {"books", "categories"}, allEntries = true)
    public Book save(BookDTO book) {
        return bookRepository.save(bookMapper.toEntity(book));
    }
    @CacheEvict(value = {"books", "categories"}, allEntries = true)
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
    @CacheEvict(value = {"books", "categories"}, allEntries = true)
    public Book update(BookDTO book) {
        return bookRepository.save(bookMapper.toEntity(book));
    }
}