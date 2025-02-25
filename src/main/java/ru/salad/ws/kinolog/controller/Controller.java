package ru.salad.ws.kinolog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.salad.ws.kinolog.entity.Content;
import ru.salad.ws.kinolog.service.Service;
import ru.salad.ws.kinolog.util.ContentErrorResponse;
import ru.salad.ws.kinolog.util.ContentNotFoundException;

@RestController
@RequestMapping(value = "/content")
@RequiredArgsConstructor
public class Controller {
    private final Service service;

    @GetMapping("/{id}")
    public ResponseEntity<Content> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }


    @ExceptionHandler
    private ResponseEntity<ContentErrorResponse> handleException(ContentNotFoundException exception) {
        ContentErrorResponse response = new ContentErrorResponse(
            "Контент с этим ID не найден",
            System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
