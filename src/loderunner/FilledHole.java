package loderunner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class FilledHole extends Hole implements Block{


	public boolean isFilled = false; 
	public int superCounter;
	public FilledHole(Game game, int superCounter) {
		super(game);
		this.superCounter = superCounter;
	}
	@Override
	public void drawRec(Graphics2D g, int x, int y) {
		
		
	}
	
	@Override
	public void drawRec(Graphics2D g){
		Rectangle air = new Rectangle(x,y, 25,25);
		g.setColor(Color.BLUE);
		g.fill(air);
		g.draw(air);
		if(this.superCounter == 300){
			Game.currentLevel[x/25][y/25] = 'b';
			game.holes[this.x/25][this.y/25] = null;
		}
		this.superCounter++;
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
