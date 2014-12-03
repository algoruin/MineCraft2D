package com.game.engine.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class BaseObject {

	public float x, y, w, h, hspd, vspd;
	public String id;

	public BaseObject(float x, float y, float w, float h, String id) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.id = id;
	}

	public abstract void update(LinkedList<BaseObject> ents);

	public abstract void draw(Graphics g);

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, (int) w, (int) h);
	}

}
