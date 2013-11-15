package loderunner;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

import javax.imageio.ImageIO;



public class Hero extends Moveable implements Block{

	private Graphics2D g;
	int interval = 3;
	Timer timer;
	

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
	
	public void dig(String direction, Game game){
		if(direction == "left"){
			game.currentLevel[this.x/25-1][this.y/25+1] = 'a';
			Hole newhole = new Hole();
			newhole.setPosition((this.x/25-1)*25, (this.y/25+1)*25);
			newhole.index = this.holes.size();
			this.holes.add(newhole);
		}

		if(direction == "right"){
			game.currentLevel[this.x/25+1][this.y/25+1] = 'a';
			Hole newhole = new Hole();
			newhole.setPosition((this.x/25+1)*25, (this.y/25+1)*25);
			newhole.index = this.holes.size();
			this.holes.add(newhole);
		}
	}
	private final int setInterval() {
	    if (interval == 1)
	        timer.cancel();
	    return --interval;
	}
	
	@Override
	public void die(){
		if(this.getBlockType("current") == 'b'){
			for(int i = 0; i< this.holes.size(); i++){
				Game.currentLevel[this.holes.get(i).x][this.holes.get(i).y] ='b' ;
			}
			this.holes = new ArrayList<Hole>();
			this.isDead = true;
		}
	}

	
}
