package ru.mokinnart.skillbox.mod7.dto;
import java.time.Instant;
import java.util.Set;

import lombok.Data;
import ru.mokinnart.skillbox.mod7.enums.TaskStatus;
@Data
public class TaskDTO {
    private String id;
    private String name;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
    private TaskStatus status;
    private String authorId;
    private String assigneeId;
    private Set<String> observerIds;
}