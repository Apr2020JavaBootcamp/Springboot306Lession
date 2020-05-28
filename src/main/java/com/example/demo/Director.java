package com.example.demo;

import com.sun.deploy.panel.CacheSettingsDialog;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String genre;

        @OneToMany(mappedBy = "director", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<Movie> movies;

    public Director() {
        this.movies = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
