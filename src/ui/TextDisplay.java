package ui;


import ent.Ent;

import java.awt.*;

public class TextDisplay extends Ent{
    private String text;
    private int textSize;
    private Font textFont;
    private Color textColor;
    private Ent parentEntity;

    public TextDisplay() {

    }

    public void render(Graphics g) {
        g.setColor(textColor);
        if(parentEntity != null) {
            g.drawString(text, (int)(x+parentEntity.getX()), (int)(y+parentEntity.getY()));
        }
        else {
            g.drawString(text, (int)x, (int)y);
        }
    }

    public String getText() {
        return text;
    }

    public int getTextSize() {
        return textSize;
    }

    public Font getTextFont() {
        return textFont;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public void setTextFont(Font textFont) {
        this.textFont = textFont;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }
}
