package object;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import framework.GameObject;
import framework.Handler;
import framework.ID;
import window.Game;

public class Ball extends GameObject{
	
	public static Color color;
	private int ticks = 0;
	
	private Handler handler;

	public Ball(float x, float y, ID id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
		width=20;
		height=20;
		color = Color.GRAY;
		setVelY(4);
		setVelX(4);
		handler.ball1 = false;
		handler.ball2 = false;
	}

	@Override
	public void tick() {
		ticks++;
		
		x +=velX;
		y +=velY;
		
		if(y<0) velY = -velY;
		if(y>Game.HEIGHT - height) velY = -velY;
		
		if(ticks%30==0){
			if(x<0) {
				x = Game.WIDTH/2;
				setVelY(3);
				setVelX(3);
				handler.setBall1(true);
			}
			
			if(x>Game.WIDTH) {
				x = Game.WIDTH/2;
				setVelY(4);
				setVelX(4);
				handler.setBall2(true);
			}
		if(ticks>=122){
			ticks=0;
		}
		
	}
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(color);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillOval((int)x, (int)y, width, height);

		
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, width, height);
	}

}
