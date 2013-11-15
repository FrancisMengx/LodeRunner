package loderunner;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpFrame extends JFrame{
	public static final int WIDTH = 400;
	public static final int HEIGHT = 500;
	public HelpFrame(){
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("Load Runner");
		JButton back = new JButton("Back");
		back.setPreferredSize(new Dimension(150, 40));
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			
		});
		JPanel panel = new JPanel();
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		JLabel label4 = new JLabel();
		JLabel label5 = new JLabel();
		label1.setText("player use arrow keys to move our hero;\n");
		label2.setText("player use Z and X keys to dig holes;\n");
		label3.setText("player use U key to go to upper level and  key");
		label5.setText("to go down to previous level;\n");
		label4.setText("player use P key to pause game and R key to resume.");
		panel.add(back);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		this.add(panel);
		}
}	
