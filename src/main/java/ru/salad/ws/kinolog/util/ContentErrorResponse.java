package ru.salad.ws.kinolog.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContentErrorResponse {
    private String message;
    private Long timestamp;
}