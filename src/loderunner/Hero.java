package loderunner;

import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Hero extends Moveable implements Block{
	private Graphics2D g;
	int interval = 3;
	Timer timer;
	public int goldCount = 0;
	
	public Hero(Game game) {
		super(game);
	}
	public void drawRec(Graphics2D g) {
		
		this.g = g;
		try {
			if(this.direction == "left"){
				BufferedImage image = ImageIO.read(new File("src/hero_run_left.gif"));
				g.drawImage(image, null, super.x, super.y);
			}else if(this.direction == "right"){
				BufferedImage image = ImageIO.read(new File("src/hero_run_right.gif"));
				g.drawImage(image, null, super.x, super.y);
			}else{
				BufferedImage image = ImageIO.read(new File("src/sonic_face.gif"));
				g.drawImage(image, null, super.x, super.y);
			}

		} catch (IOException e) {
			// do nothing
		}
		if(this.getBlockType("current") == 'm' && Math.abs(this.x - (this.x/25)*25)<5 ){
			this.pickUpGold();
		}
	}

	@Override
	public String getType() {
		return "h";
	}

	@Override
	public boolean isDigable() {
		return false;
	}
	public void setDirection(String Direction){
		
		this.direction = Direction;
		super.direction = Direction;
	}

	@Override
	public void drawRec(Graphics2D g, int x, int y) {
		// Do nothing, this function has already been overloaded
		
	}
	
	public void dig(String direction){
		if(direction == "left"){
			if(game.currentLevel[this.x/25-1][this.y/25+1] == 'b'){
				game.currentLevel[this.x/25-1][this.y/25+1] = 'a';
				Hole newhole = new Hole(game);
				newhole.setPosition((this.x/25-1)*25, (this.y/25+1)*25);
				game.holes[this.x/25-1][this.y/25+1] = newhole;
			}
		}

		if(direction == "right"){
			if(game.currentLevel[this.x/25+1][this.y/25+1] == 'b'){
				game.currentLevel[this.x/25+1][this.y/25+1] = 'a';
				Hole newhole = new Hole(game);
				newhole.setPosition((this.x/25+1)*25, (this.y/25+1)*25);
				game.holes[this.x/25+1][this.y/25+1] = newhole;
			}
			
		}
	}
	
	@Override
	public void die(){
		if(this.getBlockType("current") == 'b'){
			this.isDead = true;
		}
	}
	@Override
	public void pickUpGold() {
			this.game.currentLevel[this.x/25][this.y/25] = 'k';
			this.goldCount++;
	}
	

	
}
