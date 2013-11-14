package loderunner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class FilledHole extends Hole implements Block{
	public boolean isFilled = false;
	@Override
	public void drawRec(Graphics2D g, int x, int y) {
		
		
	}
	
	@Override
	public void drawRec(Graphics2D g){
		Rectangle air = new Rectangle(x,y, 25,25);
		g.setColor(Color.BLUE);
		g.fill(air);
		g.draw(air);
		if(super.counter == 300){
			Game.currentLevel[x/25][y/25] = 'b';
			Hero.holes.remove(this.index);
			super.counter =0;
		}
		super.counter++;
	}
	@Override
	public String getType() {
		return "f";
	}

	@Override
	public boolean isDigable() {
		// TODO Auto-generated method stub
		return false;
	}

}
