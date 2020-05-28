package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    MovieRepository movieRepository;

    @Override
    public void run(String... strings) throws Exception {
        Director director = new Director();
        director.setName("Steven Spielberg");
        director.setGenre("Drama");
//        directorRepository.save(director);

//        director = new Director();
//        director.setName("Alfred Hitchcock");
//        director.setGenre("Suspense");
//        directorRepository.save(director);

        Movie movie1 = new Movie();
        movie1.setTitle("Star Wars");
        movie1.setYear(1980);
        movie1.setDescription("Sci Fi about future");

        Movie movie2 = new Movie();
        movie2.setTitle("Star Wars II");
        movie2.setYear(1983);
        movie2.setDescription("Sci Fi about future");

        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie1);
        movies.add(movie2);

        director.setMovies(movies);
        directorRepository.save(director);

        movie1.setDirector(director);
        movie2.setDirector(director);
        movieRepository.save(movie1);
        movieRepository.save(movie2);

    }


}
