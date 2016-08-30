package com.schorkegame.schorke.entity;

import java.util.Random;

import com.schorkegame.schorke.graphics.Screen;
import com.schorkegame.schorke.level.Level;

public abstract class Entity {
	
	public int x;
	public int y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void tick() {
		
	}
	
	public void render(Screen screen) {
		
	}
	
	public void remove() {
		
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
}