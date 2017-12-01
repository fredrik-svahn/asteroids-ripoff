package component;

import ent.GameObject;

public abstract class Component {
    protected GameObject object;


    public Component(GameObject object) {
        this.object = object;
    }
}
