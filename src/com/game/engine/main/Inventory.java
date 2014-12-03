package com.game.engine.main;

import java.awt.Graphics;
import java.util.LinkedList;

import com.game.engine.inv.BaseItem;

public class Inventory {

	public LinkedList<BaseItem> items;

	public Inventory() {
		items = new LinkedList<BaseItem>();
	}

	public void update() {

	}

	public void draw(Graphics g) {
		for (int i = 0; i < items.size(); i += 1) {
			items.get(i).draw(g);
		}
	}

}
