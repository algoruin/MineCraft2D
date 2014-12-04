package com.game.engine.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Player extends BaseObject {

	public float grav;
	public boolean grounded = true;
	public float dir;

	public Player(float x, float y, float w, float h, String id) {
		super(x, y, w, h, id);
		grav = 0;
		dir = 0;
	}

	@Override
	public void update(LinkedList<BaseObject> ents) {
		x += hspd;
		y += vspd;
		boolean grounded = false;
		boolean moving = true;
		for (int i = 0; i < ents.size(); i += 1) {
			BaseObject block = ents.get(i);
			if (!block.id.equals("player")) {
				if (getBoundsBot().intersects(block.getBounds())) {
					vspd = 0;
					grav = 0;
					y = block.y - h;
					grounded = true;
				}
				if (getBoundsTop().intersects(block.getBounds())) {
					vspd = 0;
					y = block.y + block.h;
				}

				if (getBoundsLeft().intersects(block.getBounds())) {
					hspd = 0;
					x = block.x + block.w;
					moving = false;
				}
				if (getBoundsRight().intersects(block.getBounds())) {
					hspd = 0;
					x = block.x - w;
					moving = false;
				}
			}
		}
		if (!grounded) {
			vspd += grav;
			grav = 0.1f;
		}
		this.grounded = grounded;
		if (vspd > 1) {
			vspd = 1;
		}
		if (moving) {
			hspd = dir;
		}
		if (hspd > 1) {
			hspd = 1;
		}
		if (hspd < -1) {
			hspd = -1;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int) x, (int) y, (int) w, (int) h);
	}

	public Rectangle getBoundsBot() {
		return new Rectangle((int) x + 3, (int) (y + h) - 3, (int) (w - 7), 5);
	}

	public Rectangle getBoundsTop() {
		return new Rectangle((int) x + 3, (int) (y) - 3, (int) (w - 7), 4);
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle((int) x, (int) y + 3, (int) 2, (int) h - 6);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle((int) (x + w) - 3, (int) y + 3, (int) 3, (int) h - 6);
	}

}
