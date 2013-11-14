package loderunner;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Your team number and names here and in all your code files
 */
public class Main {

	public static final int MENU_WIDTH = 200;
	public static final int MENU_HEIGHT = 300;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final JFrame frame = new JFrame();

		frame.setSize(MENU_WIDTH, MENU_HEIGHT);
		frame.setTitle("Game Menu");
		JPanel panel = new JPanel();
		JButton newGame = new JButton("New Game");
		newGame.setPreferredSize(new Dimension(150, 40));
		newGame.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				JFrame frame;
				try {
					frame = new GameFrame();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		panel.add(newGame);
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
