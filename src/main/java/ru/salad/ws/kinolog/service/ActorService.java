package ru.salad.ws.kinolog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.salad.ws.kinolog.entity.Actor;
import ru.salad.ws.kinolog.repository.ActorRepository;
import ru.salad.ws.kinolog.util.NotFoundException;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;

    public Actor findById(Long id) {
        return actorRepository.findById(id)
            .orElseThrow(NotFoundException::new);
    }
}
