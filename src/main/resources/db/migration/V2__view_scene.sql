CREATE VIEW view_scene AS
SELECT s.id AS scene_id,
       s.description,
       s.budget,
       s.duration,
       s.film_id,
       f.title AS film_title
FROM scene s
         JOIN film f ON s.film_id = f.id;
