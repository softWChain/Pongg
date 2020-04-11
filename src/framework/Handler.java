package framework;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class Handler {
	
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public boolean up,down,ball1,ball2= false;
	
	public void tick(){
		
		for(int i=0;i<object.size();i++){
			GameObject temp = object.get(i);
			temp.tick();
		}
		
	}
	
	public void render(Graphics2D g){
		
		for(int i=0;i<object.size();i++){
			GameObject temp = object.get(i);
			temp.render(g);
		}
		
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
		
	}
	public void removeObject(GameObject object){
		this.object.remove(object);
		
	}
	
	public boolean isBall2() {
		return ball2;
	}

	public void setBall2(boolean ball) {
		this.ball2 = ball;
	}
	
	
	public boolean isBall1() {
		return ball1;
	}

	public void setBall1(boolean ball) {
		this.ball1 = ball;
	}

	public boolean isUp(){
		return up;
	}
	public void setUp(boolean up){
		this.up = up;
	}
	public boolean isDown(){
		return down;
	}
	public void setDown(boolean down){
		this.down =down;
	}
	
}
