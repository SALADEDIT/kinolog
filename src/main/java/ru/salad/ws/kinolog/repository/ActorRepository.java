package ru.salad.ws.kinolog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.salad.ws.kinolog.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
}
