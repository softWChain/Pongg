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

public class Player extends GameObject{

	private Handler handler;
	private int number1=0;
	private Random rand = new Random();
	public Player(float x, float y, ID id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
		width=15;
		height =80;
		speed = 5;
		handler.ball1 = false;
		handler.ball2 = false;
		
		
	}

	@Override
	public void tick() {
		
		x +=velX;
		y +=velY;
		
		if(handler.isDown()){
			velY= 5;
		}
		else if(!handler.isUp()){
			velY = 0;
		}
		if(handler.isUp()){
			velY = -5;
		}
		else if(!handler.down){
			velY =0;
		}
		
		if(y<0) y=0;
		if(y>Game.HEIGHT - height) y = Game.HEIGHT - height;
		
		
		for(int i =0;i<handler.object.size();i++){
			GameObject temp = handler.object.get(i);
			if(temp.getId() == ID.Ball){
				if(getBounds().intersects(temp.getBounds())){
					Ball.color = Color.CYAN;
					temp.setVelX(3 + rand.nextInt(5));
					temp.setVelY(3 + rand.nextInt(5));
				}
			}
		}
		
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.CYAN);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillRect((int)x, (int)y, width, height);
		
		if(handler.isBall1()){
			number1++;
			handler.setBall1(false);
		}
		
		g.setColor(Color.RED);
		g.drawString("SCORE : " +number1, 500, 50);
		

		
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle((int)x,(int)y,width,height);
		
	}

}
