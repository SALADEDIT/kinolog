package ru.salad.ws.kinolog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.salad.ws.kinolog.entity.Content;
import ru.salad.ws.kinolog.repository.ContentRepository;
import ru.salad.ws.kinolog.util.NotFoundException;

import jakarta.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;

    public Content findById(Long id) {
        return contentRepository.findById(id)
            .orElseThrow(NotFoundException::new);
    }

    public Page<Content> findAllByYear(Integer year, Pageable pageable) {
        return contentRepository.findAllByYear(year, pageable)
            ;
    }

    @Transactional
    public Content create(Content content) {
        return contentRepository.save(content);
    }

}
