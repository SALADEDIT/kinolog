package ru.salad.ws.kinolog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.salad.ws.kinolog.entity.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    Page<Content> findAllByYear(Integer year, Pageable pageable);

}
