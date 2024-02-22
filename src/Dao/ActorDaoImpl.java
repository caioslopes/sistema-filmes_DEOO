package Dao;

import Model.Actor;

import java.util.ArrayList;
import java.util.List;

public class ActorDaoImpl implements ActorDao {

    private static ActorDaoImpl instance = null;
    private List<Actor> dataset;

    private ActorDaoImpl(){
        dataset = new ArrayList<>();
    }

    public static ActorDaoImpl getInstance(){
        if(instance == null){
            instance = new ActorDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Actor> getAllActors() {
        return dataset;
    }

    @Override
    public Actor getActorByName(String name) {
        for(Actor a : dataset){
            if(a.getName().equals(name)){
                return a;
            }
        }
        return null;
    }

    @Override
    public void insertActor(Actor actor) {
        if(actor != null){
            if(dataset.isEmpty()){
                dataset.add(actor);
            }
            for(Actor a : dataset){
                if(!a.getName().equals(actor.getName())){
                    dataset.add(actor);
                }
            }
        }
    }

    @Override
    public void updateActor(Actor oldActor, Actor newActor) {
        for(Actor a : dataset){
            if(a.getName().equals(oldActor.getName())){
                a = newActor;
            }
        }
    }

    @Override
    public void deleteActorByName(String name) {
        for(Actor a : dataset){
            if(a.getName().equals(name)){
                dataset.remove(a);
            }
        }
    }
}
