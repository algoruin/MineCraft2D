package com.game.engine.input;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Sprites {

	public static BufferedImage getTexture(String path, int x, int y, int w, int h) {
		try {
			return ImageIO.read(Sprites.class.getResource(path)).getSubimage(x, y, w, h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
