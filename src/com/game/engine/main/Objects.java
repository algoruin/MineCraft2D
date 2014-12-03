package com.game.engine.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import com.game.engine.objects.BaseObject;
import com.game.engine.objects.ParentBlock;
import com.game.engine.objects.Player;

public class Objects {

	public LinkedList<BaseObject> ents;
	public Player player;

	public Objects() {
		ents = new LinkedList<BaseObject>();
		genWorld();
	}

	public void genWorld() {
		try {
			BufferedImage img = ImageIO.read(Objects.class.getResource("/lvl/lvl.png"));
			int width = img.getWidth();
			int height = img.getHeight();
			for (int x = 0; x < width; x += 1) {
				for (int y = 0; y < height; y += 1) {
					Color clr = new Color(img.getRGB(x, y));
					if (clr.getRed() == 0 && clr.getGreen() == 0 && clr.getBlue() == 0) {
						ents.add(new ParentBlock(x * 20, y * 20, 20, 20, "block"));
					}
					if (clr.getRed() == 0 && clr.getGreen() == 0 && clr.getBlue() == 255) {
						player = new Player(x * 20, y * 20, 20, 40, "player");
						ents.add(player);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		for (int i = 0; i < ents.size(); i += 1) {
			ents.get(i).update(ents);
		}
	}

	public void draw(Graphics g) {
		for (int i = 0; i < ents.size(); i += 1) {
			ents.get(i).draw(g);
		}
	}

}
