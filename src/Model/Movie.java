package Model;

import java.util.List;

public class Movie {

    private String title;
    private Director director;
    private List<Actor> cast;
    private int releaseYear;
    private int ranking;

    public Movie(String title, Director director, int releaseYear, int ranking){
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.ranking = validateRanking(ranking) ? ranking : 0;
    }

    public Movie(String title, Director director, List<Actor> cast, int releaseYear, int ranking){
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.releaseYear = releaseYear;
        this.ranking = validateRanking(ranking) ? ranking : 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getCast() {
        return cast;
    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    private boolean validateRanking(int ranking){
        return ranking >= 0 && ranking <= 5;
    }

}
