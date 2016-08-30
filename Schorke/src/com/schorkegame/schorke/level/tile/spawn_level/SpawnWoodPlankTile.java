package com.schorkegame.schorke.level.tile.spawn_level;

import com.schorkegame.schorke.graphics.Screen;
import com.schorkegame.schorke.graphics.Sprite;
import com.schorkegame.schorke.level.tile.Tile;

public class SpawnWoodPlankTile extends Tile {

	public SpawnWoodPlankTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}