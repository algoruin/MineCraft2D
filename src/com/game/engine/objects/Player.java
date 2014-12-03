package com.game.engine.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Player extends BaseObject {

	public Player(float x, float y, float w, float h, String id) {
		super(x, y, w, h, id);
	}

	@Override
	public void update(LinkedList<BaseObject> ents) {

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int) x, (int) y, (int) w, (int) h);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.red);
		g2d.draw(getBoundsBot());
		g2d.draw(getBoundsTop());
	}

	public Rectangle getBoundsBot() {
		return new Rectangle((int) x + 3, (int) (y + h) - 3, (int) (w - 7), 3);
	}

	public Rectangle getBoundsTop() {
		return new Rectangle((int) x + 3, (int) (y) - 1, (int) (w - 7), 3);
	}

}
