package com.schorkegame.schorke.graphics;

public class Sprite {

	public final int SIZE;
	private int x;
	private int y;
	public int[] pixels;
	private SpriteSheet spriteSheet;
	
	public static Sprite grass = new Sprite(16, 0, 1, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 2, 1, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 0, 2, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x168D81);
	
	// Spawn_Level Sprites
	public static Sprite spawn_grass = new Sprite(16, 0, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_dirt = new Sprite(16, 2, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_rock = new Sprite(16, 0, 1, SpriteSheet.spawn_level);
	public static Sprite spawn_woodPlank = new Sprite(16, 4, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_wall = new Sprite(16, 5, 0, SpriteSheet.spawn_level);
	

	// Player Sprites
	public static Sprite playerUp1 = new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite playerUp2 = new Sprite(32, 0, 6, SpriteSheet.tiles);
	public static Sprite playerUp3 = new Sprite(32, 0, 7, SpriteSheet.tiles);
	public static Sprite playerDown1 = new Sprite(32, 2, 5, SpriteSheet.tiles);
	public static Sprite playerDown2 = new Sprite(32, 2, 6, SpriteSheet.tiles);
	public static Sprite playerDown3 = new Sprite(32, 2, 7, SpriteSheet.tiles);
	public static Sprite playerSide1 = new Sprite(32, 1, 5, SpriteSheet.tiles);
	public static Sprite playerSide2 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	public static Sprite playerSide3 = new Sprite(32, 1, 7, SpriteSheet.tiles);

	public Sprite(int size, int x, int y, SpriteSheet spriteSheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.spriteSheet = spriteSheet;

		load();
	}
	
	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColour(color);
	}

	private void setColour(int color) {
		for(int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = color;
		}
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = spriteSheet.pixels[(x + this.x) + (y + this.y) * spriteSheet.SIZE];
			}
		}
	}
}