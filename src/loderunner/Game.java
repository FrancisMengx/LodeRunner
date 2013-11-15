package loderunner;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	public String file = "src/level";
	public static char currentLevel[][] = new char[40][30];
	public Hole holes[][] = new Hole[40][30];
	public Hero newHero = null;
	public int goldCount;
	public static boolean isRunning = true;
	public int level;
	public ArrayList<Guard> newGuard = new ArrayList<Guard>();

	public Game(int level) {
		Scanner scan;
		try {
			scan = new Scanner(new File(file + level));
			this.level = level;
			int lineNo = 0;
			while (scan.hasNext()) {
				String line = scan.next();
				for (int i = 0; i < line.length(); i++) {
					this.currentLevel[i][lineNo] = line.charAt(i);
				}
				lineNo++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
		}
		
	}

	public void loadLevel(Graphics2D g) {
		this.goldCount = 0;
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 30; j++) {
				if (this.currentLevel[i][j] == 'b') {
					Brick newBrick = new Brick();
					newBrick.drawRec(g, i * 25, j * 25);
				} else if (this.currentLevel[i][j] == 'k'
						| this.currentLevel[i][j] == 'h'
						| this.currentLevel[i][j] == 'g') {
					Air newAir = new Air();
					newAir.drawRec(g, i * 25, j * 25);
				} else if (this.currentLevel[i][j] == 'r') {
					Rope newRope = new Rope();
					newRope.drawRec(g, i * 25, j * 25);
				} else if (this.currentLevel[i][j] == 'l') {
					Ladder newLadder = new Ladder();
					newLadder.drawRec(g, i * 25, j * 25);
				} else if (this.currentLevel[i][j] == 'm') {
					this.goldCount++;
					Gold newGold = new Gold();
					newGold.drawRec(g, i * 25, j * 25);
				} else if (this.currentLevel[i][j] == 's') {
					Board newBoard = new Board();
					newBoard.drawRec(g, i * 25, j * 25);
				} else if (this.currentLevel[i][j] == 'a') {
					this.holes[i][j].drawRec(g);
				} else if (this.currentLevel[i][j] == 'f') {
					this.holes[i][j].drawRec(g);
				}
			}
		}
		
		if(!this.newGuard.isEmpty()){
			for(int i = 0; i < this.newGuard.size();i++){
				if(this.newGuard.get(i).hasGold){
					this.goldCount++;
				}
			}
		}
		System.out.println(this.goldCount);
		if(this.goldCount == 0){
			for(int k = 0; k<28;k++){
				this.currentLevel[38][k] = 'l';
			}
		}
	}

	public Hero getHero() {
		if (this.newHero == null) {
			for (int i = 0; i < 40; i++) {
				for (int j = 0; j < 30; j++) {
					if (this.currentLevel[i][j] == 'h') {
						this.newHero = new Hero(this);
						newHero.setPosition(i * 25, j * 25);
						return newHero;
					}
				}
			}
		} else if (this.newHero.isDead) {
			for (int i = 0; i < 40; i++) {
				for (int j = 0; j < 30; j++) {
					if (this.currentLevel[i][j] == 'h') {
						this.newHero = new Hero(this);
						newHero.setPosition(i * 25, j * 25);
						return newHero;
					}
				}
			}
		}
		return this.newHero;
	}

	public ArrayList<Guard> getGuards() {
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 30; j++) {
				if (this.currentLevel[i][j] == 'g') {
					Guard g = new Guard(this);
					g.setPosition(i * 25, j * 25);
					this.newGuard.add(g);
				}
			}
		}
		return this.newGuard;
	}

	public void reload() throws FileNotFoundException {
		Scanner scan = new Scanner(new File(file + level));
		this.level = level;
		int lineNo = 0;
		while (scan.hasNext()) {
			String line = scan.next();
			for (int i = 0; i < line.length(); i++) {
				this.currentLevel[i][lineNo] = line.charAt(i);
			}
			lineNo++;
		}
	}
}
