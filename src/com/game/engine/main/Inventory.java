package com.game.engine.main;

import java.awt.Graphics;
import java.util.LinkedList;

import com.game.engine.graphics.InventoryWindow;
import com.game.engine.inv.BaseItem;

public class Inventory {

	public LinkedList<BaseItem> items;
	public InventoryWindow win;

	public Inventory() {
		items = new LinkedList<BaseItem>();
		win = new InventoryWindow(this, 180, 240);
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
			items.get(i).draw(g);
		}
	}

}
