CREATE VIEW view_character AS
SELECT c.id AS character_id,
       c.name AS character_name,
       c.actor,
       c.cost,
       c.role,
       c.film_id,
       c.stock,
       s.description AS scene_description
FROM movie_character c
         JOIN scene s ON c.film_id = s.film_id;
