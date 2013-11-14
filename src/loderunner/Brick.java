package loderunner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Brick implements Block{

	@Override
	public void drawRec(Graphics2D g, int x, int y) {
		Rectangle brick = new Rectangle(x,y, 25,25);
		g.setColor(Color.getHSBColor(120,220,150));
		g.fill(brick);
		g.draw(brick);
//		try {
//			BufferedImage image = ImageIO.read(new File("src/Brick.gif"));
//			g.drawImage(image, null, x, y);
//		} catch (IOException e) {
//			// do nothing
//		}
	}

	@Override
	public String getType() {
		return "b";
	}

	@Override
	public boolean isDigable() {
		return true;
	}


}
