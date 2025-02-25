package ru.salad.ws.kinolog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.salad.ws.kinolog.entity.Content;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Content, Long> {
    Page<Content> findAllByYear(Integer year, Pageable pageable);

}
