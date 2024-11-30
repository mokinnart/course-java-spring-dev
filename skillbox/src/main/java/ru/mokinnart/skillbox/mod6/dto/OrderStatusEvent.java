package ru.mokinnart.skillbox.mod6.dto;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusEvent {
    private String status;
    private Instant date;
}