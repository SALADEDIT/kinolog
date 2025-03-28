package ru.salad.ws.kinolog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.salad.ws.kinolog.entity.Actor;
import ru.salad.ws.kinolog.entity.Content;
import ru.salad.ws.kinolog.repository.ActorRepository;
import ru.salad.ws.kinolog.repository.ContentRepository;
import ru.salad.ws.kinolog.util.NotFoundException;

import jakarta.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;
    private final ContentRepository contentRepository;

    public Actor findById(Long id) {
        return actorRepository.findById(id)
            .orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Actor create(Actor actor) {
        if (actor.getContent().getContentId() != null) {
            Content content = contentRepository.findById(actor.getContent().getContentId())
                .orElseThrow(NotFoundException::new);
            actor.setContent(content);
        }

        return actorRepository.save(actor);
    }
}
