package main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame{
	public Window(String title, int width, int height) {
		setTitle(title);
		setSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
