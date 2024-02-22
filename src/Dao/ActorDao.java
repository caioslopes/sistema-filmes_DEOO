package Dao;

import Model.Actor;

import java.util.List;

public interface ActorDao {

    List<Actor> getAllActors();
    Actor getActorByName(String name);
    void insertActor(Actor actor);
    void updateActor(Actor oldActor, Actor newActor);
    void deleteActorByName(String name);


}
