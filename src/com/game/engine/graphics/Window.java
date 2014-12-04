package com.game.engine.graphics;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Window {

	public int x, y, width, height, mouseX, mouseY;
	public boolean dragging;
	public BufferedImage img;

	public Window(int x, int y, int width, int height, BufferedImage img) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		mouseX = 0;
		mouseY = 0;
		dragging = false;
	}

	public abstract void update();

	public abstract void draw(Graphics g);

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, 16);
	}

}
