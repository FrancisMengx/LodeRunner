package loderunner;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameFrame extends JFrame{
	public static final int WIDTH = 1020;
	public static final int HEIGHT = 795;
	public GameFrame() throws FileNotFoundException{
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("Load Runner");
		Game game = new Game();
		GameComponent gcomp = new GameComponent(game, this);
		this.add(gcomp);
		this.addKeyListener(new LodeKeyListener(this, game));
//		gcomp.run();
		Thread t1 = new Thread(gcomp);
		t1.start();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void displayGameover(){
		final JFrame frame = new JFrame();

		frame.setSize(300, 200);
		frame.setTitle("Game Over");
		JLabel newlabel = new JLabel("Game Over");
		newlabel.setSize(100, 100);
		frame.add(newlabel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
