package com.game.engine.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.game.engine.graphics.InventoryWindow;
import com.game.engine.input.Sprites;
import com.game.engine.inv.BaseItem;
import com.game.engine.inv.ItemWoodenPick;
import com.game.engine.inv.ItemWoodenSword;

public class Inventory {

	public LinkedList<BaseItem> items;
	public InventoryWindow win;

	public Inventory() {
		items = new LinkedList<BaseItem>();
		win = new InventoryWindow(this, 360, 480);
		genInv();
	}

	public void genInv() {
		BufferedImage woodensword = Sprites.getTexture("/inv/items.png", 0, 0, 28, 28);
		BufferedImage woodenpick = Sprites.getTexture("/inv/items.png", 28, 0, 28, 28);
		if (items.size() < 9) {
			items.add(new ItemWoodenSword(0, "woodsword", woodensword));
			items.add(new ItemWoodenPick(1, "woodpick", woodenpick));
		}
	}

	public void update() {
		win.update();
		for (int i = 0; i < items.size(); i += 1) {
			items.get(i).update();
		}
	}

	public void draw(Graphics g) {
		win.draw(g);
		for (int i = 0; i < items.size(); i += 1) {
			items.get(i).draw(g, win.x, win.y);
		}
	}

}
