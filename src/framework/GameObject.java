package framework;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class GameObject {
	
	
	protected float x;
	protected float y;
	protected float velX,velY;
	protected ID id;
	protected int speed;
	protected int width,height;
	
	public GameObject(float x,float y,ID id){
		this.id=id;
		this.x=x;
		this.y=y;
	}
	
	public abstract void tick();
	public abstract void render(Graphics2D g);
	public abstract Rectangle getBounds();

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
	
		
}
