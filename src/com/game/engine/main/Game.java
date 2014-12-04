package com.game.engine.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.game.engine.input.Input;

public class Game extends Canvas implements Runnable {

	public static final long serialVersionUID = 1L;

	public static int width = 900;
	public static int height = 600;
	public static final String title = "Game - 0.01";

	public Objects ents;
	public Inventory inv;
	public Quests quests;
	public static GameState state;

	public Game() {
		Dimension dim = new Dimension(width, height);
		setPreferredSize(dim);
		setMaximumSize(dim);
		setMinimumSize(dim);
		JFrame frame = new JFrame(title);
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		new Thread(this).start();
	}

	public static void main(String[] args) {
		new Game();
	}

	public void run() {
		double last = System.nanoTime();
		double delta = 0;
		double fps = 100000000.0 / 60.0;
		init();
		while (true) {
			double now = System.nanoTime();
			delta += (now - last) / fps;
			last = now;
			while (delta >= 0) {
				update();
				delta -= 1;
			}
			draw();
		}
	}

	public void init() {
		width = getWidth();
		height = getHeight();
		ents = new Objects();
		inv = new Inventory();
		quests = new Quests(this);
		Input input = new Input(ents.player, inv);
		addKeyListener(input);
		addMouseListener(input);
		addMouseMotionListener(input);

		state = GameState.Game;
	}

	public void update() {
		ents.update();
		quests.update();
		if (state == GameState.Inventory) {
			inv.update();
		}
	}

	public void draw() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());

		int x = -(int) ((ents.player.x + (ents.player.w / 2)) - (getWidth() / 2));
		int y = -(int) ((ents.player.y + (ents.player.h / 2)) - (getHeight() / 2));

		((Graphics2D) g).translate(x, y);

		ents.draw(g);
		quests.draw(g);

		((Graphics2D) g).translate(-x, -y);

		if (state == GameState.Inventory) {
			inv.draw(g);
		}

		g.dispose();
		bs.show();
	}
}
