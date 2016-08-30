package com.schorkegame.schorke.level;

import com.schorkegame.schorke.graphics.Screen;
import com.schorkegame.schorke.level.tile.Tile;

public class Level {

	protected Tile[] tiles;
	protected int width;
	protected int height;
	protected int[] tilesInt;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
	}

	protected void generateLevel() {

	}

	private void loadLevel(String path) {

	}

	public void tick() {

	}

	public void time() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffsets(xScroll, yScroll);

		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				// getTile(x, y).render(x, y, screen);
				if (x < 0 || y < 0 || x >= width || y >= height) {
					Tile.voidTile.render(x, y, screen);
				} else {
					tiles[x + y * 16].render(x, y, screen);
				}
			}
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.voidTile;
		if (tilesInt[x + y * width] == 0)
			return Tile.grass;
		if (tilesInt[x + y * width] == 1)
			return Tile.flower;
		if (tilesInt[x + y * width] == 2)
			return Tile.rock;
		return Tile.voidTile;
	}
}