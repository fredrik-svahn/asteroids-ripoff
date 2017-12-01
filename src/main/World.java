package main;
import java.util.LinkedList;
import ent.GameObject;

public class World {
    private LinkedList<GameObject> gameObjectList;

    public World() {
        gameObjectList = new LinkedList<GameObject>();
    }

    public GameObject getGameObject(int i) {
        return gameObjectList.get(i);
    }

    public int getSize() {
        return gameObjectList.size();
    }

    public void addGameObject(GameObject e) {
        gameObjectList.add(e);
    }
}
