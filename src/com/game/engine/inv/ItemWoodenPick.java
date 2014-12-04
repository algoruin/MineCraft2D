package com.game.engine.inv;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ItemWoodenPick extends BaseItem {

	BufferedImage icon;

	public ItemWoodenPick(int num, String id, BufferedImage icon) {
		super(num, id);
		this.icon = icon;
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics g, int winx, int winy) {
		g.drawImage(icon, winx + 38 + x * 32, winy + 66 + y * 32, 28, 28, null);
	}

}
