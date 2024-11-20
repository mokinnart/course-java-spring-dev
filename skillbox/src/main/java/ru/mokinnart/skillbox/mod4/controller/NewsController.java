package ru.mokinnart.skillbox.mod4.controller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ru.mokinnart.skillbox.mod4.CheckNewsOwnership;
import ru.mokinnart.skillbox.mod4.dto.NewsDTO;
import ru.mokinnart.skillbox.mod4.service.NewsService;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;
    @GetMapping
    public ResponseEntity<Page<NewsDTO>> getAllNews(Pageable pageable) {
        return ResponseEntity.ok(newsService.getAllNews(pageable));
    }
    @GetMapping("/filter")
    public ResponseEntity<Page<NewsDTO>> filterNews(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String author,
              Pageable pageable) {
        return ResponseEntity.ok(newsService.filterNews(category, author, pageable));
    }
    @GetMapping("/{newsId}")
    public ResponseEntity<NewsDTO> getNewsById(@PathVariable Long newsId) {
        return ResponseEntity.ok(newsService.getNewsById(newsId));
    }
    @PostMapping
    public ResponseEntity<NewsDTO> createNews(@Valid @RequestBody NewsDTO newsDTO) {
        return ResponseEntity.ok(newsService.createNews(newsDTO));
    }
    @PutMapping("/{newsId}")
    @CheckNewsOwnership
    public ResponseEntity<NewsDTO> updateNews(@PathVariable Long newsId, @Valid @RequestBody NewsDTO newsDTO) {
        return ResponseEntity.ok(newsService.updateNews(newsId, newsDTO));
    }
    @DeleteMapping("/{newsId}")
    @CheckNewsOwnership
    public ResponseEntity<Void> deleteNews(@PathVariable Long newsId) {
        newsService.deleteNews(newsId);
        return ResponseEntity.noContent().build();
    }
}