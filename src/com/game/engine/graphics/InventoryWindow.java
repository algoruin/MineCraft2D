package com.game.engine.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.game.engine.input.Sprites;
import com.game.engine.main.Game;
import com.game.engine.main.Inventory;

public class InventoryWindow extends Window {

	public Inventory inv;
	public int cx, cy;
	public BufferedImage slot;

	public InventoryWindow(Inventory inv, int width, int height) {
		super((Game.width / 4) - (width / 2), (Game.height / 2) - (height / 2), width, height, Sprites.getTexture("/inv/win.png", 0, 0, 48, 64));
		this.inv = inv;
		this.slot = Sprites.getTexture("/inv/slot.png", 0, 0, 16, 16);
	}

	@Override
	public void update() {
		if (dragging) {
			x = mouseX - cx;
			y = mouseY - cy;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, width, height, null);
		for (int x = this.x + 36; x < this.x + width - 64; x += 32) {
			for (int y = this.y + 64; y < this.y + height - 32; y += 32) {
				g.drawImage(slot, x, y, 32, 32, null);
			}
		}
	}

}
