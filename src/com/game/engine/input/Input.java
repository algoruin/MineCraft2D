package com.game.engine.input;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.game.engine.main.Game;
import com.game.engine.main.GameState;
import com.game.engine.main.Inventory;
import com.game.engine.objects.Player;

public class Input implements KeyListener, MouseListener, MouseMotionListener {

	Player player;
	Inventory inv;
	boolean[] keys;
	boolean pressed;
	int cW, cH;

	public Input(Player player, Inventory inv) {
		this.player = player;
		this.inv = inv;
		keys = new boolean[2];
		pressed = false;
		cW = 20;
		cH = 50;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE && player.grounded) {
			player.vspd = -5;
			player.grav = 0.1f;
			player.grounded = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			player.hspd = -1;
			player.dir = player.hspd;
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			player.hspd = +1;
			player.dir = player.hspd;
			keys[0] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			if (!keys[0]) {
				player.hspd = 0;
			}
			keys[1] = false;
			player.dir = player.hspd;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			if (!keys[1]) {
				player.hspd = 0;
			}
			keys[0] = false;
			player.dir = player.hspd;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == 'e') {
			if (Game.state == GameState.Game) {
				Game.state = GameState.Inventory;
			} else if (Game.state == GameState.Inventory) {
				Game.state = GameState.Game;
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (Game.state == GameState.Inventory && pressed) {
			inv.win.mouseX = e.getX();
			inv.win.mouseY = e.getY();
		}
		inv.win.dragging = true;
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (new Rectangle(e.getX() - (cW / 2), e.getY() - (cH / 2), cW, cH).intersects(inv.win.getBounds()) && Game.state == GameState.Inventory && !pressed) {
			inv.win.cx = e.getX() - inv.win.x;
			inv.win.cy = e.getY() - inv.win.y;
			pressed = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		inv.win.dragging = false;
		pressed = false;
	}

}
