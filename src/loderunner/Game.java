package loderunner;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	public String file = "src/level1";
	public static char currentLevel[][] = new char[40][30];
	public static Block currentLevelBlocks[][] = new Block[40][30];
	public Hero newHero = null;
	public ArrayList<Guard> newGuard = new ArrayList<Guard>();
	
	public Game() throws FileNotFoundException{
		Scanner scan = new Scanner(new File(file));
		int lineNo = 0;
		while(scan.hasNext()){
			String line = scan.next();
			for(int i = 0; i < line.length(); i++){
				this.currentLevel[i][lineNo] = line.charAt(i);
			}
			lineNo++;
		}
	}
	public void loadLevel(Graphics2D g){

			for(int i = 0; i < 40; i++){
				for(int j = 0; j<30; j++){
				if(this.currentLevel[i][j] == 'b'){
					Brick newBrick = new Brick();
					newBrick.drawRec(g, i *25, j*25);
					this.currentLevelBlocks[i][j] = newBrick;
				}
				else if(this.currentLevel[i][j] == 'k'|this.currentLevel[i][j]== 'h'|this.currentLevel[i][j] == 'g'){
					Air newAir = new Air();
					newAir.drawRec(g, i *25, j*25);
					this.currentLevelBlocks[i][j] = newAir;
				}
				else if(this.currentLevel[i][j] == 'r'){
					Rope newRope = new Rope();
					newRope.drawRec(g, i *25, j*25);
					this.currentLevelBlocks[i][j] = newRope;
				}
				else if(this.currentLevel[i][j] == 'l'){
					Ladder newLadder = new Ladder();
					newLadder.drawRec(g, i *25, j*25);
					this.currentLevelBlocks[i][j] = newLadder;
				}
			}
		}
	}
	public Hero getHero(){
		if(this.newHero == null){
		for(int i = 0; i < 40; i++ ){
			for(int j = 0; j <30; j++){
				if(this.currentLevel[i][j] =='h'){
					this.newHero = new Hero();
					newHero.setPosition(i*25, j*25);
					this.currentLevelBlocks[i][j] = newHero;
					return newHero;
				}
			}
		}
		}else if(this.newHero.isDead){
			for(int i = 0; i < 40; i++ ){
				for(int j = 0; j <30; j++){
					if(this.currentLevel[i][j] =='h'){
						this.newHero = new Hero();
						newHero.setPosition(i*25, j*25);
						this.currentLevelBlocks[i][j] = newHero;
						return newHero;
					}
				}
			}
		}
		return this.newHero;		
	}
	public ArrayList<Guard> getGuards(){
		for(int i = 0; i < 40; i++ ){
			for(int j = 0; j <30; j++){
				if(this.currentLevel[i][j] =='g'){
					Guard g = new Guard();
					g.setPosition(i*25, j*25);
					this.currentLevelBlocks[i][j] = g;
					this.newGuard.add(g);
				}
			}
		}
		return this.newGuard;
	}
}
	
