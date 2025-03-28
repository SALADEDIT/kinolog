CREATE TABLE if not exists content
(
    content_id     BIGSERIAL PRIMARY KEY,
    name           varchar                         NOT NULL,
    year           int                             NOT NULL,
    country        varchar                         not null,
    genre          varchar                         not null,
    director       varchar                         not null,
    world_premiere DATE                            not null,
    viewed         varchar check ( 'yes' or 'no' ) not null
);

create table if not exists actor
(
    actor_id   BIGSERIAL PRIMARY KEY,
    name       varchar,
    content_id INT REFERENCES content (content_id) ON DELETE CASCADE
);