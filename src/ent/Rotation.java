package ent;

public class Rotation {
    public float angle;

    public static float toRads(float degrees) {
        return (float)(Math.PI / 180) * degrees;
    }

}
