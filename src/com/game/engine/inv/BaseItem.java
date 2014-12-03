package com.game.engine.inv;

import java.awt.Graphics;

public abstract class BaseItem {

	public int num;
	public String id;

	public BaseItem(int num, String id) {
		this.num = num;
		this.id = id;
	}

	public abstract void draw(Graphics g);

}
