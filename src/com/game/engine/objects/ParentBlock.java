package com.game.engine.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class ParentBlock extends BaseObject {

	public ParentBlock(float x, float y, float w, float h, String id) {
		super(x, y, w, h, id);
	}

	@Override
	public void update(LinkedList<BaseObject> ents) {

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect((int) x, (int) y, (int) w, (int) h);
	}

}
