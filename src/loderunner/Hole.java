package loderunner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Hole implements Block{
	public boolean isFilled = false;
	public int x;
	public int y;
	public Game game;
	public int counter = 0;
	public int index;
	public Hole(Game game){
		this.game = game;

	}
	
	public void drawRec(Graphics2D g){
		
		Rectangle air = new Rectangle(this.x,this.y, 25,25);
		g.setColor(Color.GREEN);
		g.fill(air);
		g.draw(air);
		if(counter == 300){
			Game.currentLevel[this.x/25][this.y/25] = 'b';
			game.holes[this.x/25][this.x/25] = null;
			counter =0;
		}
		this.counter++;
	}
	
	
	@Override
	public void drawRec(Graphics2D g, int x, int y) {
		// Overloaded do nothing

		
	}

	@Override
	public String getType() {
		return "a";
	}

	@Override
	public boolean isDigable() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setPosition(int x ,int y){
		this.x = x;
		this.y = y;
	}
}
