package loderunner;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

public class LodeKeyListener implements KeyListener{
	public static Hero hero;
	public GameFrame frame;
	public GameComponent comp;
	private Game game;
	public LodeKeyListener(GameFrame frame, Game game, GameComponent comp){
		this.hero = game.getHero();
		this.comp = comp;
		this.frame = frame;
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			this.hero.setDirection("left");
			break;
		case KeyEvent.VK_RIGHT:
			this.hero.setDirection("right");
			break;
		case KeyEvent.VK_UP:
			this.hero.setDirection("up");
			break;
		case KeyEvent.VK_DOWN:
			this.hero.setDirection("down");
			break;
		case KeyEvent.VK_Z:
			this.hero.dig("left");
			break;
		case KeyEvent.VK_X:
			this.hero.dig("right");
			break;
		case KeyEvent.VK_U:
				this.comp.changeLevel('u');		
			break;
		case KeyEvent.VK_D:
				this.comp.changeLevel('d');
			break;
		case KeyEvent.VK_R:
			this.game.isRunning = true;
			break;
		case KeyEvent.VK_P:
				this.game.isRunning = false;
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		this.hero.setDirection(null);
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		//Do nothing
		
	}
}
