package ent;

import main.Input;
import main.World;

import java.awt.*;

public interface Entity {
    public void update(World world, Graphics g, Input input);
}


