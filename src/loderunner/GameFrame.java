package loderunner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	public static final int WIDTH = 1020;
	public static final int HEIGHT = 795;
	public Thread t1;
	public GameFrame() throws FileNotFoundException{
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("Load Runner");
		
		Game game = new Game(1);
		GameComponent gcomp = new GameComponent(game, this);
		this.add(gcomp);
		this.addKeyListener(new LodeKeyListener(this, game, gcomp));
//		gcomp.run();
		t1 = new Thread(gcomp);
		t1.start();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}