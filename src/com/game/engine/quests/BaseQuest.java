package com.game.engine.quests;

import java.awt.Graphics;

import com.game.engine.main.Inventory;

public abstract class BaseQuest {

	public boolean completed;
	public String desc;
	public Inventory inv;

	public BaseQuest(String desc, Inventory inv) {
		this.desc = desc;
		this.inv = inv;
	}

	public void checkQuest() {
		String[] quest = desc.split(";");
		for (int i = 0; i < quest.length; i += 1) {
			if (quest[i].startsWith("bring:")) {
				String item = quest[i].split(":")[1].split(" ")[1];
				int count = Integer.valueOf(quest[i].split(":")[1].split(" ")[0]);
				int c = 0;
				for (int j = 0; j < inv.items.size(); j += 1) {
					if (inv.items.get(j).id.equals(item)) {
						c += 1;
					}
				}
				if (c == count) {
					completed = true;
				}
			}
		}
	}

	public abstract void update();

	public abstract void draw(Graphics g);

}
