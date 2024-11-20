package ru.mokinnart.skillbox.mod4.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ru.mokinnart.skillbox.mod4.CheckNewsOwnership;
import ru.mokinnart.skillbox.mod4.dto.CommentDTO;
import ru.mokinnart.skillbox.mod4.service.CommentService;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @GetMapping("/news/{newsId}")
    public ResponseEntity<List<CommentDTO>> getCommentsByNewsId(@PathVariable Long newsId) {
        return ResponseEntity.ok(commentService.getCommentsByNewsId(newsId));
    }
    @PostMapping("/news/{newsId}")
    public ResponseEntity<CommentDTO> createComment(@PathVariable Long newsId, @Valid @RequestBody CommentDTO commentDTO) {
        return ResponseEntity.ok(commentService.createComment(newsId, commentDTO));
    }
    @PutMapping("/{commentId}")
    @CheckNewsOwnership
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long commentId, @Valid @RequestBody CommentDTO commentDTO) {
        return ResponseEntity.ok(commentService.updateComment(commentId, commentDTO));
    }
    @DeleteMapping("/{commentId}")
    @CheckNewsOwnership
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
}