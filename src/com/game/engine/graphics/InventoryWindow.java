package com.game.engine.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.game.engine.input.Sprites;
import com.game.engine.main.Game;
import com.game.engine.main.Inventory;

public class InventoryWindow extends Window {

	public Inventory inv;
	public int cx, cy;

	public InventoryWindow(Inventory inv, int width, int height) {
		super((Game.width / 4) - (width / 2), (Game.height / 2) - (height / 2), width, height, Sprites.getTexture("/inv/win.png", 0, 0, 48, 64));
		this.inv = inv;
	}

	@Override
	public void update() {
		if (dragging) {
			x = mouseX - cx;
			y = mouseY - cy;
		}
		System.out.println(x + ", " + y);
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, width, height, null);
		g.setColor(Color.red);
		((Graphics2D) g).draw(getBounds());
	}

}
