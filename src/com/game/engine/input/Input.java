package com.game.engine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.game.engine.objects.Player;

public class Input implements KeyListener {

	Player player;
	boolean[] keys;

	public Input(Player player) {
		this.player = player;
		keys = new boolean[2];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE && player.grounded) {
			player.vspd = -10;
			player.grounded = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			player.hspd = -1;
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			player.hspd = 1;
			keys[0] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			if (!keys[0]) {
				player.hspd = 0;
				keys[1] = false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			if (!keys[1]) {
				player.hspd = 0;
				keys[0] = false;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == ' ' && player.grounded == true) {
			player.vspd = -10;
			player.grounded = false;
		}
		if (e.getKeyChar() == 'q') {
			player.hspd = -1;
			keys[1] = true;
		}
		if (e.getKeyChar() == 'd') {
			player.hspd = 1;
			keys[0] = true;
		}
	}

}
