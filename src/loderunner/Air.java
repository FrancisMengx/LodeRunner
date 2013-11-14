package loderunner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Air implements Block{

	@Override
	public void drawRec(Graphics2D g, int x, int y) {
		
		Rectangle air = new Rectangle(x,y, 25,25);
		g.setColor(Color.WHITE);
		g.fill(air);
		g.draw(air);

//		try {
//			BufferedImage image = ImageIO.read(new File("src/Air.gif"));
//			g.drawImage(image, null, x, y);
//		} catch (IOException e) {
//			// do nothing
//		}
	}

	@Override
	public String getType() {
		return "k";
	}

	@Override
	public boolean isDigable() {
		return false;
	}





}
