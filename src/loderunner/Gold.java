package loderunner;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Gold implements Block{

	@Override
	public void drawRec(Graphics2D g, int x, int y) {
		
		try {
			BufferedImage image;
			image = ImageIO.read(new File("src/Gold.gif"));
			g.drawImage(image, null, x, y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
