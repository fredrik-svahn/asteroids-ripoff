package ent;

import component.Position;

public class Rotation {
    public float angle;

    public static float toRads(float degrees) {
        return (float)(Math.PI / 180) * degrees;
    }

    public static Position rotate(Position currentPos, Position center, float angle) {
        Position newPosition = new Position();
        newPosition.x = currentPos.x - center.x;
        newPosition.y = currentPos.y - center.y;

        newPosition.x = (float)(newPosition.x*Math.cos(angle) - newPosition.y*Math.sin(angle));
        newPosition.y = (float)(newPosition.x*Math.sin(angle) + newPosition.y*Math.cos(angle));

        newPosition.x += center.x;
        newPosition.y += center.y;
        return newPosition;
    }

}
