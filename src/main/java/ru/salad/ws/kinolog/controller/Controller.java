package ru.salad.ws.kinolog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.salad.ws.kinolog.entity.Content;
import ru.salad.ws.kinolog.service.Service;
import ru.salad.ws.kinolog.util.ContentErrorResponse;
import ru.salad.ws.kinolog.util.ContentNotFoundException;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/content", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class Controller {
    private final Service service;

    @GetMapping("/{id}")
    public ResponseEntity<Content> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    public Page<Content> findByYear(@RequestParam(value = "year") Integer year, Pageable pageable) {
        return service.findAllByYear(year, pageable);
    }


    @PostMapping
    public ResponseEntity<Content> create(@RequestBody Content content) {
        return new ResponseEntity<>(service.create(content), HttpStatus.CREATED);
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
