package com.schorkegame.schorke.level.tile;

import com.schorkegame.schorke.graphics.Screen;
import com.schorkegame.schorke.graphics.Sprite;

public class GrassTile extends Tile {

	public GrassTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}