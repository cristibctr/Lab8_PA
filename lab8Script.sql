DROP TABLE movies;

DROP TABLE genres;

DROP TABLE movie_genre;

DROP TABLE actors;

DROP TABLE directors;

CREATE TABLE movies(
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	title VARCHAR(25) UNIQUE NOT NULL,
	release_date DATE,
	duration NUMBER(5),
	score DOUBLE
);

CREATE TABLE genres(
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	name VARCHAR(25) UNIQUE NOT NULL
);

CREATE TABLE movie_genre(
	id_movie INTEGER REFERENCES movies(id),
	id_genre INTEGER REFERENCES genres(id)
);

CREATE TABLE actors(
	name VARCHAR(25) NOT NULL,
	movie_title VARCHAR(25) REFERENCES movies(title)
);

CREATE TABLE directors(
	name VARCHAR(25) NOT NULL,
	movie_title VARCHAR(25) REFERENCES movies(title)
);