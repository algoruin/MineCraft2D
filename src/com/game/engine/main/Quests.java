package com.game.engine.main;

import java.awt.Graphics;
import java.util.LinkedList;

import com.game.engine.quests.BaseNPC;
import com.game.engine.quests.IntroNPC;

public class Quests {

	public LinkedList<BaseNPC> npcs;

	public Quests(Game game) {
		npcs = new LinkedList<BaseNPC>();
		genWorld(game);
	}

	public void genWorld(Game game) {
		npcs.add(new IntroNPC(60, 880, "Intro", game));
	}

	public void update() {
		for (int i = 0; i < npcs.size(); i += 1) {
			npcs.get(i).update();
		}

	}

	public void draw(Graphics g) {
		for (int i = 0; i < npcs.size(); i += 1) {
			npcs.get(i).draw(g);
		}
	}

}
