CREATE TABLE IF NOT EXISTS film (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    director VARCHAR(255) NOT NULL,
    synopsis TEXT NOT NULL,
    duration DECIMAL(10, 2) NOT NULL
    );

CREATE TABLE IF NOT EXISTS scene (
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    budget DECIMAL(10, 2) NOT NULL,
    duration INT NOT NULL,
    film_id INT NOT NULL,
    FOREIGN KEY (film_id) REFERENCES film(id)
    );

CREATE TABLE IF NOT EXISTS movie_character (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    actor VARCHAR(255) NOT NULL,
    cost DECIMAL(10, 2) NOT NULL,
    role VARCHAR(255) NOT NULL,
    film_id INT NOT NULL,
    scene_id INT,
    stock INT DEFAULT 1,
    FOREIGN KEY (film_id) REFERENCES film(id),
    FOREIGN KEY (scene_id) REFERENCES scene(id)
    );
