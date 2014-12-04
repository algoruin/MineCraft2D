package com.game.engine.quests;

import java.awt.Graphics;

public abstract class BaseNPC {

	public BaseQuest quest;
	public String name;
	public float x, y;

	public BaseNPC(float x, float y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}

	public abstract void update();

	public abstract void draw(Graphics g);

}
