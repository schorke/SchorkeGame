package com.schorkegame.schorke.level.tile;

import com.schorkegame.schorke.graphics.Screen;
import com.schorkegame.schorke.graphics.Sprite;
import com.schorkegame.schorke.level.tile.spawn_level.SpawnDirtTile;
import com.schorkegame.schorke.level.tile.spawn_level.SpawnGrassTile;
import com.schorkegame.schorke.level.tile.spawn_level.SpawnRockTile;
import com.schorkegame.schorke.level.tile.spawn_level.SpawnWallTile;
import com.schorkegame.schorke.level.tile.spawn_level.SpawnWoodPlankTile;

public class Tile {

	public int x;
	public int y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawn_dirt = new SpawnDirtTile(Sprite.spawn_dirt);
	public static Tile spawn_rock = new SpawnRockTile(Sprite.spawn_rock);
	public static Tile spawn_woodPlank = new SpawnWoodPlankTile(Sprite.spawn_woodPlank);
	public static Tile spawn_wall = new SpawnWallTile(Sprite.spawn_wall);
	
	public final static int color_spawn_grass = 0xff00ff00;
	public final static int color_spawn_dirt = 0xffffff00;
	public final static int color_spawn_rock = 0xff7f7f00;
	public final static int color_spawn_woodPlank = 0xff693b12;
	public final static int color_spawn_wall = 0xff727272;
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen scree) {
		
	}
	
	public boolean solid() {
		return false;
	}
}