package ent;

import java.awt.*;

import component.*;
import main.Event;
import main.World;

public abstract class GameObject {
    protected float x = 0;
    protected float y = 0;
    protected float width = 0;
    protected float height = 0;

    public void handleEvent(Event e) { }
    public void update(World world, Graphics g) { }
    public void sendEvent(Event e, GameObject target) {
        target.handleEvent(e);
    }
}
