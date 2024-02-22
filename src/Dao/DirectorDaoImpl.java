package Dao;

import Model.Director;

import java.util.ArrayList;
import java.util.List;

public class DirectorDaoImpl implements DirectorDao{

    private static DirectorDaoImpl instance = null;
    private List<Director> dataset;

    private DirectorDaoImpl(){
        dataset = new ArrayList<>();
    }

    public static DirectorDaoImpl getInstance(){
        if(instance == null){
            instance = new DirectorDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Director> getAllDirectors() {
        return dataset;
    }

    @Override
    public Director getDirectorByName(String name) {
        for(Director d : dataset){
            if(d.getName().equals(name)){
                return d;
            }
        }
        return null;
    }

    @Override
    public void insertDirector(Director director) {
        if(director != null){
            if(dataset.isEmpty()){
                dataset.add(director);
            }
            for(Director d : dataset){
                if(!d.getName().equals(director.getName())){
                    dataset.add(director);
                }
            }
        }
    }

    @Override
    public void updateDirector(Director oldDirector, Director newDirector) {
        for(Director d : dataset){
            if(d.getName().equals(oldDirector.getName())){
                d = newDirector;
            }
        }
    }

    @Override
    public void deleteDirectorByName(String name) {
        for(Director d : dataset){
            if(d.getName().equals(name)){
                dataset.remove(d);
            }
        }
    }
}
