package ru.salad.ws.kinolog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
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

    public Page<Content> findAllByYear(Integer year, Pageable pageable) {
        return repository.findAllByYear(year, pageable);
    }

    @Transactional
    public Content create(Content content) {
        return repository.save(content);
    }

}
