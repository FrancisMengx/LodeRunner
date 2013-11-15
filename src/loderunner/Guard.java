package loderunner;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Guard extends Moveable implements Block{

	public int counter = 0;
	
	public Guard(Game game) {
		super(game);
	}
	public void drawRec(Graphics2D g) {
		Rectangle guard = new Rectangle(this.x,this.y,25,25);
		g.setColor(Color.BLACK);
		g.fill(guard);
		if(this.getBlockType("current") == 'f'){
			this.counter++;
		}
		if(this.counter == 220){
			this.getOut();
			this.counter = 0;
		}
		g.draw(guard);	
		
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "g";
	}

	@Override
	public boolean isDigable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void drawRec(Graphics2D g, int x, int y) {
		//overloaded do nothing
	}
	public void getOut(){
		Game.currentLevel[this.x/25][this.y/25] = 'b';
		if(this.direction == "left"){
			this.x = this.x-25;
			this.y = this.y -25;
		}else{
			this.x = this.x + 25;
			this.y = this.y -25;
		}
	}
	public int getClosestDown(){
		ArrayList<Integer> xlist = new ArrayList<Integer>();
		for(int i = 0; i < 40; i++){
			if(Game.currentLevel[i][this.y/25+1] == 'l'|Game.currentLevel[i][this.y/25+1] == 'k'){
				xlist.add(i*25);
			}
		}
		int min = 1000;
		for(int j = 0; j <xlist.size(); j++){
			if(Math.abs(xlist.get(j)-this.x)< min){
				min = xlist.get(j);
			}
		}
		return min;
	}
	public int getClosestUp(){
		ArrayList<Integer> xlist = new ArrayList<Integer>();
		for(int i = 0; i < 40; i++){
			if(Game.currentLevel[i][this.y/25] == 'l'){
				xlist.add(i*25);
			}
		}
		int min = 1000;
		for(int j = 0; j <xlist.size(); j++){
			if(Math.abs(xlist.get(j)-this.x)< min){
				min = xlist.get(j);
			}
		}
		return min;
	}
}
