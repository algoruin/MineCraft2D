package com.game.engine.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Player extends BaseObject {

	public float grav;
	public boolean grounded = true;

	public Player(float x, float y, float w, float h, String id) {
		super(x, y, w, h, id);
		grav = 0;
	}

	@Override
	public void update(LinkedList<BaseObject> ents) {
		boolean grounded = false;
		for (int i = 0; i < ents.size(); i += 1) {
			BaseObject block = ents.get(i);
			if (!block.id.equals("player")) {
				if (getBoundsBot().intersects(block.getBounds())) {
					vspd = 0;
					grav = 0;
					y = block.y - h;
					grounded = true;
				}

				if (getBoundsLeft().intersects(block.getBounds())) {
					hspd = 0;
					x = block.x + block.w + 2;
				}
				if (getBoundsRight().intersects(block.getBounds())) {
					hspd = 0;
					x = block.x - w - 2;
				}
			}
		}
		if (!grounded) {
			grav = 0.5f;
			vspd += grav;
		}
		this.grounded = grounded;
		if (vspd > 1) {
			vspd = 1;
		}
		x += hspd;
		y += vspd;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int) x, (int) y, (int) w, (int) h);
		g.setColor(Color.red);
		((Graphics2D) g).draw(getBoundsBot());
	}

	public Rectangle getBoundsBot() {
		return new Rectangle((int) x + 3, (int) (y + h) - 3, (int) (w - 7), 4);
	}

	public Rectangle getBoundsTop() {
		return new Rectangle((int) x + 3, (int) (y) - 3, (int) (w - 7), 4);
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle((int) x - 2, (int) y + 3, (int) 2, (int) h - 6);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle((int) (x + w) - 2, (int) y + 3, (int) 3, (int) h - 6);
	}

}
