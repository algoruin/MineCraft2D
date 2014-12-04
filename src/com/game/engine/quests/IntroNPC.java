package com.game.engine.quests;

import java.awt.Color;
import java.awt.Graphics;

import com.game.engine.main.Game;

public class IntroNPC extends BaseNPC {

	public IntroNPC(float x, float y, String name, Game game) {
		super(x, y, name);
		quest = new IntroQuest("bring:1 woodpick", "Bring me one wooden pick", game.inv);
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, 20, 40);
	}

}
