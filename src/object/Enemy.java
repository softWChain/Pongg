package object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.Random;

import framework.GameObject;
import framework.Handler;
import framework.ID;
import window.Game;

public class Enemy extends GameObject{

	private Handler handler;
	private float diffX,diffY,distance;
	private int number2=0;
	private Random rand = new Random();
	public Enemy(float x, float y, ID id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
		width=15;
		height =80;
		speed = 5;
		
		
	}

	@Override
	public void tick() {
		
		x +=velX;
		y +=velY;
		
		if(y<0) y=0;
		if(y>Game.HEIGHT - height) y = Game.HEIGHT - height;
		

		for(int i=0;i<handler.object.size();i++){
			GameObject temp = handler.object.get(i);
			if(temp.getId() == ID.Ball){
				
				diffX = x - temp.getX() ;
				diffY = y - temp.getY() ;
				
				distance = (float) Math.sqrt((x - temp.getX())*(x - temp.getX())+(y - temp.getY())*(y - temp.getY()));
			}
			if(temp.getId() == ID.Ball){
				if(temp.getX()>Game.WIDTH){
					temp.setVelX(0);
					temp.setVelY(0);
				}
			}
			
		}
		
		velY = (-1/distance)*diffY*speed;
		
		
		collosion();


	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillRect((int)x, (int)y, width, height);
		
		if(handler.isBall2()){
			number2++;
			handler.setBall2(false);
		}
		
		g.setColor(Color.CYAN);
		g.drawString("SCORE : " +number2, 50, 50);
		

	}
	
	private void collosion(){
		for(int i=0;i<handler.object.size();i++){
			GameObject temp = handler.object.get(i);
			if(temp.getId() == ID.Ball){
				
				if(getBounds().intersects(temp.getBounds())){
					Ball.color = Color.RED;
					temp.setVelX(-rand.nextInt(7)-5);
					temp.setVelY(-rand.nextInt(10));
				}
				
			}
		}
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, width, height);
	}

}
