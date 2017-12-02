package main;
import ent.Entity;

import java.util.LinkedList;

public class World {
    private LinkedList<Entity> entityList;

    public World() {
        entityList = new LinkedList<Entity>();
    }

    public Entity getGameObject(int i) {
        return entityList.get(i);
    }

    public int getSize() {
        return entityList.size();
    }

    public void addGameObject(Entity e) {
        entityList.add(e);
    }
}
