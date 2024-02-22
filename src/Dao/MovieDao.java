package Dao;

import Model.Movie;

import java.util.List;

public interface MovieDao {

    List<Movie> getAllMovies();
    Movie getMovieByTitle(String title);
    void insertMovie(Movie movie);
    void updateMovie(Movie oldMovie, Movie newMovie);
    void deleteMovieByTitle(String title);

}
