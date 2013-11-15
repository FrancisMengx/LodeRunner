package loderunner;

import java.util.ArrayList;

public abstract class Moveable {
	public String direction;
	public int oriX;
	public int oriY;
	public int x;
	public Game game;
	public int y;
	public boolean isFilling = false;
	public boolean isDead = false;

	public Moveable(Game game) {
		this.game = game;
	}

	public void move() {
		// System.out.println(this.getCurrentBlockType());
		if (this.getBlockType("current") == 'a'
				&& this.getBlockType("above") == 'k'
				&& (this.getBlockType("left") == 'b'
						| this.getBlockType("left") == 'a' | this
						.getBlockType("left") == 's')
				&& (this.getBlockType("right") == 'b'
						| this.getBlockType("right") == 'a' | this
						.getBlockType("right") == 's')) {
			Game.currentLevel[this.x / 25][this.y / 25] = 'f';
			int superCount = this.game.holes[this.x / 25][this.y / 25].counter;
			this.game.holes[this.x / 25][this.y / 25] = new FilledHole(
					this.game, superCount);
			this.game.holes[this.x / 25][this.y / 25].setPosition(
					(this.x / 25) * 25, (this.y / 25) * 25);

		}
		if(!(this.getBlockType("current") == 'a'|this.getBlockType("current") == 'f')|this instanceof Hero){
			this.checkAndDrop();
		}
		
		if (this.direction == "left") {
			this.checkAndMoveHor();
		}
		if (this.direction == "right") {
			this.checkAndMoveHor();
		}
		if (this.direction == "up") {
			this.checkAndMoveVer();
		}
		if (this.direction == "down") {
			this.checkAndMoveVer();
		}
	}

	private void checkAndDrop() {
		if (this.getBlockType("current") != 'r'
				&& (this.getBlockType("below") == 'k' | this
						.getBlockType("below") == 'a')) {
			if (this.getBlockType("below") == 'a') {
				if (this.x - (this.x / 25) * 25 < 2) {
					this.direction = "";
					this.y += 2;
				}

			} else {
				if(this.getBlockType("right") != 'l'){
					this.y += 2;
				}
				
			}
			

		}
		if (this.getBlockType("current") == 'r' && this.direction == "down") {
			this.y += 2;
		}
	}

	private void checkAndMoveHor() {
		if (this.direction == "left") {
			if (this.getBlockType("left") != 'b'
					&& this.getBlockType("left") != 's'
					&& this.getBlockType("left") != 'a') {
				this.x -= 1;
			}
		}
		if ((this.direction == "right")) {
			if (this.getBlockType("right") != 'b'
					&& this.getBlockType("right") != 's'
					&& this.getBlockType("right") != 'a') {
				this.x += 1;
			}
		}
	}

	private void checkAndMoveVer() {
		if (this.direction == "up") {
			if (this.getBlockType("current") == 'l') {
				if (Math.abs(this.x - (this.x / 25) * 25) < 12) {
					this.y -= 1;
				}

			}else if (this.getBlockType("current") == 'k'
					&& this.getBlockType("below") == 'l') {
				this.y -= 1;
			}
		}
		if (this.direction == "down") {
			if (this.getBlockType("below") == 'l') {
				this.y += 1;
			}
		}
	}

	public char getBlockType(String dir) {

		if (dir == "current")
			return Game.currentLevel[this.x / 25][this.y / 25];
		else if (dir == "above")
			return Game.currentLevel[this.x / 25][this.y / 25 - 1];
		else if (dir == "below")
			return Game.currentLevel[this.x / 25][this.y / 25 + 1];
		else if (dir == "left")
			return Game.currentLevel[this.x / 25 - 1][this.y / 25];
		else
			return Game.currentLevel[this.x / 25 + 1][this.y / 25];

	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.oriX = x;
		this.y = y;
		this.oriY = y;
	}

	public void die() {
		if (this.getBlockType("current") == 'b') {
			this.isDead = true;
		}
	}

	public abstract void pickUpGold();

}
