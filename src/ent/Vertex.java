package ent;

public class Vertex {
    private double x;
    private double y;

    public Vertex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public double getRotateX(double angle) {
        return x * Math.cos(angle) - y * Math.sin(angle);
    }

    public double getRotateY(double angle) {
        return x * Math.sin(angle) + y * Math.cos(angle);
    }

}
