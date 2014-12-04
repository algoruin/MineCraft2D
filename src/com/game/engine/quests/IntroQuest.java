package com.game.engine.quests;

import java.awt.Color;
import java.awt.Graphics;

import com.game.engine.main.Inventory;

public class IntroQuest extends BaseQuest {

	public String description;

	public IntroQuest(String action, String desc, Inventory inv) {
		super(action, inv);
		this.description = desc;
	}

	@Override
	public void update() {
		checkQuest();
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawString(description, 20, 20);
	}

}
