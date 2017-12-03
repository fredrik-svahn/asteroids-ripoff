package main;
import ent.Entity;

import java.util.LinkedList;

public class World {
    private LinkedList<Entity> entityList;

    public World() {
        entityList = new LinkedList<Entity>();
    }

    public Entity getEntity(int i) {
        return entityList.get(i);
    }

    public int getSize() {
        return entityList.size();
    }

    public void addEntity(Entity e) {
        entityList.add(e);
    }

    public void removeEntity(Entity e) { entityList.remove(e);}
}
