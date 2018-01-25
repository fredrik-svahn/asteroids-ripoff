package component;

public class Position {
    public float x;
    public float y;

    public Position() {
        this(0, 0);
    }

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "{x: " + x + ", y: " + y + "}";
    }
}
