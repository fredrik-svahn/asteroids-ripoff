package ent;

import java.awt.*;
import java.util.ArrayList;

public class Bounds {
    private ArrayList<Vertex> vertices;

    public Bounds() {
        vertices = new ArrayList<Vertex>();
    }

    public void addVertex(double x, double y) {
        vertices.add(new Vertex(x,y));
    }

    public void removeVertex(int i) {
        vertices.remove(i);
    }

    public void removeVertex(Vertex v) {
        vertices.remove(v);
    }

    public void render(Graphics g, Color color, double angle, double centerX, double centerY) {
        int nPoints = vertices.size();
        int[] xPoints = new int[nPoints];
        int[] yPoints = new int[nPoints];

        for(int i = 0; i < vertices.size(); i++ ) {
            Vertex v = vertices.get(i);
            xPoints[i] = (int)(v.getRotateX(angle) + centerX);
            yPoints[i] = (int)(v.getRotateY(angle) + centerY);
        }

        g.setColor(color);
        g.fillPolygon(xPoints, yPoints, nPoints);
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public Polygon toPolygon() {
        Polygon pg = new Polygon();
        for(int i = 0; i < vertices.size(); i++) {
            pg.xpoints[i] = (int)vertices.get(i).getX();
            pg.ypoints[i] = (int)vertices.get(i).getY();
        }

        pg.npoints = vertices.size();

        return pg;
    }

    public Polygon toWorldPolygon(Ent relativeTo) {
        Polygon pg = new Polygon();
        for(int i = 0; i < vertices.size(); i++) {
            pg.xpoints[i] = (int)(vertices.get(i).getRotateX(relativeTo.getAngle()) + relativeTo.getX());
            pg.ypoints[i] = (int)(vertices.get(i).getRotateY(relativeTo.getAngle()) + relativeTo.getY());
        }

        pg.npoints = vertices.size();

        return pg;
    }


}
