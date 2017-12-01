package ent;

import java.awt.*;

import main.Event;
import main.World;

public abstract class GameObject {
    public void handleEvent(Event e) { }
    public void update(World world, Graphics g) {}

    public void sendEvent(Event e, GameObject target) {
        target.handleEvent(e);
    }
}
