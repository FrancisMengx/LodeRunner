package loderunner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class SuperSpeed implements Block{

	@Override
	public void drawRec(Graphics2D g, int x, int y) {
		Rectangle brick = new Rectangle(x,y, 25,25);
		g.setColor(Color.RED);
		g.fill(brick);
		g.draw(brick);
		
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDigable() {
		// TODO Auto-generated method stub
		return false;
	}

}
