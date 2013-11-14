package loderunner;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class GameComponent extends JComponent implements Runnable {
	public static final int UPDATE_INTERVAL_MS = 10;
	public Game game;
	public ArrayList<Guard> guards;
	public int lives = 1;
	public Hero hero;

	public GameFrame gameFrame;
	Graphics2D g2;
	
	public GameComponent(Game game, GameFrame gameFrame){
		this.game = game;
		this.hero = game.getHero();
		this.guards = game.getGuards();
		this.gameFrame = gameFrame;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2 = (Graphics2D) g;
		
		if(this.hero.holes.size()>0){
			for(int i = 0; i< this.hero.holes.size(); i++){
				this.hero.holes.get(i).drawRec(g2);
				for(Guard guard: this.guards){
					if(this.hero.holes.get(i) instanceof FilledHole && guard.getBlockType("current") == 'f'){
						guard.counter++;
					}		
				}
			}
		}
		
		game.loadLevel(g2);
		for(Guard guard : this.guards){
		if(Math.abs(this.hero.x - guard.x) < 10 && Math.abs(this.hero.y - guard.y) < 10){
			this.hero.isDead = true;
		}
		}
		if(this.hero.isDead){
			for(Guard guard : this.guards){
				guard.isDead = true;
			}
		}
		this.hero.drawRec(g2);
		for(int i = 0 ;i<this.guards.size();i++){
			this.guards.get(i).drawRec(g2);
			if(this.guards.get(i).isDead){
				int x = this.guards.get(i).oriX;
				int y = this.guards.get(i).oriY;
				Guard newguard = new Guard();
				newguard.setPosition(x, y);
				this.guards.set(i, newguard);
			}
		}
		
		if(this.hero.isDead){
			if(this.lives != 0){
				this.hero = game.getHero();
				this.guards = game.getGuards();
				LodeKeyListener.hero = this.hero;
			}
		}
		
		
	}
	

	@Override
	public void run() {
		GuardThread gt1 = new GuardThread();
		gt1.start();
			while(true){
				this.hero.move();
				this.hero.die();
				repaint();
				try {
					Thread.sleep(UPDATE_INTERVAL_MS);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	}
	class GuardThread extends Thread{
		 @Override
		 public void run(){
		      while(true){
		    	  chase();
		    	  try {
						Thread.sleep(UPDATE_INTERVAL_MS);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		      }
		   }
		 
		 private void chase(){
			 for(Guard guard : guards){
			 if(Math.abs(guard.y - hero.y)<2|guard.getBlockType("below")=='a'|guard.getBlockType("current") == 'a'){
	    		  if(guard.x > hero.x){
		    		  guard.direction = "left";
		    		  guard.move();
		    		  guard.die();
		    		  
		    	  }else if(guard.x < hero.x){
		    		  guard.direction = "right";
		    		  guard.move();
		    		  guard.die();
		    	  }
	    	  }else{
	    		  if(guard.y <hero.y){
	    			  int downX = guard.getClosestDown();
	    			  if(guard.getBlockType("below") == 'l'&&Math.abs(guard.x -(guard.x/25)*25) < 2){
	    				  guard.direction = "down";
			    		  guard.move();
			    		  guard.die();
	    			  }else{
	    				  if(guard.x > downX){
				    		  guard.direction = "left";
				    		  guard.move();
				    		  guard.die();
				    		  
				    	  }else if(guard.x < downX){
				    		  guard.direction = "right";
				    		  guard.move();
				    		  guard.die();
				    	  }else{
				    		  guard.direction = "down";
				    		  guard.move();
				    		  guard.die();
				    	  }
	    			  }
	    			  
	    		  }else{
	    			  int upX = guard.getClosestUp();
	    			  if((guard.getBlockType("current") == 'l'|guard.getBlockType("below") == 'l')
	    					  && Math.abs(guard.x -(guard.x/25)*25) < 2){
	    				  guard.direction = "up";
			    		  guard.move();
			    		  guard.die();
	    			  }else{
	    				  if(guard.x > upX){
				    		  guard.direction = "left";
				    		  guard.move();
				    		  guard.die();
				    		  
				    	  }else if(guard.x < upX){
				    		  guard.direction = "right";
				    		  guard.move();
				    		  guard.die();
				    	  }
	    			  }
	    		  }
	    	  }
			 }
		 }
	}
	

}