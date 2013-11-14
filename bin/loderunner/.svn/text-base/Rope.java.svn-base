package loderunner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rope implements Block{

	@Override
	public void drawRec(Graphics2D g, int x, int y) {
		Rectangle Rope = new Rectangle(x,y, 25,25);
		g.setColor(Color.GREEN);
		g.fill(Rope);
		g.draw(Rope);
		//		try {
//			BufferedImage image = ImageIO.read(new File("src/Rope.gif"));
//			g.drawImage(image, null, x, y);
//		} catch (IOException e) {
//			// do nothing
//		}
	}

	@Override
	public String getType() {
		return "r";
	}

	@Override
	public boolean isDigable() {
		return false;
	}
}
