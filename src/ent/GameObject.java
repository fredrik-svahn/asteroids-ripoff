package ent;

import java.awt.*;

import component.*;
import main.Event;
import main.World;

public abstract class GameObject {
    protected float x;
    protected float y;
    protected float width;
    protected float height;

    public void handleEvent(Event e) { }
    public void update(World world, Graphics g) { }
    public void sendEvent(Event e, GameObject target) {
        target.handleEvent(e);
    }
}
