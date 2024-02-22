package Dao;

import Model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl implements MovieDao {

    private static MovieDaoImpl instance = null;
    private List<Movie> dataset;

    private MovieDaoImpl(){
        dataset = new ArrayList<>();
    }

    public static MovieDaoImpl getInstance(){
        if(instance == null){
            instance = new MovieDaoImpl();
        }
        return instance;
    }


    @Override
    public List<Movie> getAllMovies() {
        return dataset;
    }

    @Override
    public Movie getMovieByTitle(String title) {
        for(Movie m : dataset){
            if(m.getTitle().equals(title)){
                return m;
            }
        }
        return null;
    }

    @Override
    public void insertMovie(Movie movie) {
        if(movie != null){
            dataset.add(movie);
        }
    }

    @Override
    public void updateMovie(Movie oldMovie, Movie newMovie) {
        for(Movie m : dataset){
            if(m.getTitle().equals(oldMovie.getTitle())){
                m = newMovie;
            }
        }
    }

    @Override
    public void deleteMovieByTitle(String title) {
        for(Movie m : dataset){
            if(m.getTitle().equals(title)){
                dataset.remove(m);
            }
        }
    }
}
