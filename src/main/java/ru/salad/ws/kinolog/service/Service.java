package ru.salad.ws.kinolog.service;

import lombok.RequiredArgsConstructor;
import ru.salad.ws.kinolog.entity.Content;
import ru.salad.ws.kinolog.repository.Repository;
import ru.salad.ws.kinolog.util.ContentNotFoundException;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {
    private final Repository repository;

    public Content findById(Long id) {
        return repository.findById(id)
            .orElseThrow(ContentNotFoundException::new);
    }


}
