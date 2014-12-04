package com.game.engine.inv;

import java.awt.Graphics;

public abstract class BaseItem {

	public int num, x, y;
	public String id;

	public BaseItem(int num, String id) {
		this.num = num;
		this.id = id;
		for (int i = 0; i < num; i += 1) {
			x += 1;
			if (x > 9) {
				x = 0;
				y += 1;
			}
		}
	}

	public abstract void update();

	public abstract void draw(Graphics g, int winx, int winy);

}
