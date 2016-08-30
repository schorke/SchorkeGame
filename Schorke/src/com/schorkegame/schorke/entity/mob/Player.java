package com.schorkegame.schorke.entity.mob;

import com.schorkegame.schorke.graphics.Screen;
import com.schorkegame.schorke.graphics.Sprite;
import com.schorkegame.schorke.input.Keyboard;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;

	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.playerDown1;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.playerDown1;
	}

	public void tick() {
		int xa = 0;
		int ya = 0;
		if (anim < 7500) {
			anim++;
		} else {
			anim = 0;
		}
		if (input.up)
			ya = ya - 2;
		if (input.down)
			ya = ya + 2;
		if (input.left)
			xa = xa - 2;
		if (input.right)
			xa = xa + 2;

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
	}

	public void render(Screen screen) {
		int flip = 0;
		if (dir == 0) {
			sprite = Sprite.playerUp1;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.playerUp2;
				} else {
					sprite = Sprite.playerUp3;
				}
			}
		}
		if (dir == 1) {
			sprite = Sprite.playerSide1;
			if (walking) {
				if (anim % 20 > 5 && anim % 20 <= 10) {
					sprite = Sprite.playerSide1;
				} else {
					if (anim % 20 > 10) {
						sprite = Sprite.playerSide2;
					} else {
						sprite = Sprite.playerSide3;
					}
				}
			}
		}
		if (dir == 2) {
			sprite = Sprite.playerDown1;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.playerDown2;
				} else {
					sprite = Sprite.playerDown3;
				}
			}
		}
		if (dir == 3) {
			sprite = Sprite.playerSide1;
			flip = 1;
			if (walking) {
				if (anim % 20 > 5 && anim % 20 <= 10) {
					sprite = Sprite.playerSide1;
				} else {
					if (anim % 20 > 10) {
						sprite = Sprite.playerSide2;
					} else {
						sprite = Sprite.playerSide3;
					}
				}
			}
		}
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}
}