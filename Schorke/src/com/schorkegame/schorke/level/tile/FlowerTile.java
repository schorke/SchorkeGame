package com.schorkegame.schorke.level.tile;

import com.schorkegame.schorke.graphics.Screen;
import com.schorkegame.schorke.graphics.Sprite;

public class FlowerTile extends Tile {

	public FlowerTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}