package component;

import ent.Entity;
import main.World;

public class Creator {
    public void spawn(World w, Entity e) {
        w.addEntity(e);
    }
}
