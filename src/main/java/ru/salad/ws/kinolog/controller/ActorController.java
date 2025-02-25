package ru.salad.ws.kinolog.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.salad.ws.kinolog.entity.Actor;
import ru.salad.ws.kinolog.service.ActorService;
import ru.salad.ws.kinolog.util.ErrorResponse;
import ru.salad.ws.kinolog.util.NotFoundException;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/actor", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ActorController {
    private final ActorService service;

    @GetMapping("/{id}")
    public ResponseEntity<Actor> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(NotFoundException exception) {
        ErrorResponse response = new ErrorResponse(
            "Актёр с этим ID не найден",
            System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
