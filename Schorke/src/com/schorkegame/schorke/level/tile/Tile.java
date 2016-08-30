package com.schorkegame.schorke.level.tile;

import com.schorkegame.schorke.graphics.Screen;
import com.schorkegame.schorke.graphics.Sprite;

public class Tile {

	public int x;
	public int y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen scree) {
		
	}
	
	public boolean solid() {
		return false;
	}
}