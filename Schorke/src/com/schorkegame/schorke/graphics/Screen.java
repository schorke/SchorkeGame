package com.schorkegame.schorke.graphics;

import java.util.Random;

import com.schorkegame.schorke.entity.mob.Player;
import com.schorkegame.schorke.level.tile.Tile;

public class Screen {

	public int width;
	public int height;
	public int[] pixels;

	public final int mapSize = 64;
	public final int mapSizeMask = mapSize - 1;
	private int tileResolution = 16;
	private int tileResolutionShiftedRight = (int) Math.sqrt(tileResolution);

	public int xOffset, yOffset;

	public int[] tiles = new int[mapSize * mapSize];

	private Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

		for (int i = 0; i < mapSize * mapSize; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	/*
	 * public void render(int xOffset, int yOffset) { for (int y = 0; y <
	 * height; y++) { int yp = y + yOffset; if (yp < 0 || yp >= height)
	 * continue; for (int x = 0; x < width; x++) { int xp = x + xOffset; if (xp
	 * < 0 || xp >= width) continue; // int tileIndex = ((xx >> //
	 * tileResolutionShiftedRight)&mapSizeMask) + ((yy >> //
	 * tileResolutionShiftedRight)&mapSizeMask) * mapSize; //episode // 16
	 * pixels[xp + yp * width] = Sprite.grass.pixels[(x & 15) + (y & 15) *
	 * Sprite.grass.SIZE]; } } }
	 */

	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}

	public void renderPlayer(int xp, int yp, Sprite sprite, int flip) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 32; y++) {
			int ya = y + yp;
			int ys = y;
			if(flip == 2 || flip == 3) {
				ys = y;
			}
			for (int x = 0; x < 32; x++) {
				int xa = x + xp;
				int xs = x;
				if(flip == 1 || flip == 3) { 
					xs = 31 - x;
				}
				if (xa < -32 || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				int color = sprite.pixels[xs + ys * 32];
				if (color != 0xFFFF00FF)
					pixels[xa + ya * width] = color;
			}
		}
	}

	public void setOffsets(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}