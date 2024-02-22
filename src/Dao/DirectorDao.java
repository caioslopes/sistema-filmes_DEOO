package Dao;

import Model.Director;

import java.util.List;

public interface DirectorDao {
    List<Director> getAllDirectors();
    Director getDirectorByName(String name);
    void insertDirector(Director director);
    void updateDirector(Director oldDirector, Director newDirector);
    void deleteDirectorByName(String name);
}
