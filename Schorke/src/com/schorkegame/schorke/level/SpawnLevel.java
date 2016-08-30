package com.schorkegame.schorke.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.schorkegame.schorke.level.tile.Tile;

public class SpawnLevel extends Level {

	public SpawnLevel(String path) {
		super(path);
	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void generateLevel() {
		
		
		/*for(int i = 0; i < levelPixels.length; i++) {
			if(levelPixels[i] == 0xff00ff00) {
				tiles[i] = Tile.grass;
			}
			if(levelPixels[i] == 0xffffff00) {
				tiles[i] = Tile.flower;
			}
			if(levelPixels[i] == 0xff7f7f00) {
				tiles[i] = Tile.rock;
			}
		}*/
	}
}