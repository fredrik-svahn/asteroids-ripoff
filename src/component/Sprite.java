package component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {
    public BufferedImage image;

    public static BufferedImage createBufferedImage(String filename) throws IOException {
        File file = new File(filename);

        if(!file.canRead()) {
            throw new IOException("File not found");
        }

        BufferedImage in = ImageIO.read(file);
        return in;
    }

    public void draw(Graphics g, float x, float y, float width, float height, float angle) {
        Graphics2D g2d = (Graphics2D)(g);
        AffineTransform transform = g2d.getTransform();
        g2d.translate(x+width/2, y+height/2);
        g2d.rotate(angle);
        g2d.drawImage(image, (int)-width/2,(int)-height/2, (int)width, (int)height, null);
        g2d.setTransform(transform);
    }
}
