package window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import framework.Handler;
import framework.ID;
import input.KeyInput;
import object.Ball;
import object.Enemy;
import object.Player;

public class Game extends Canvas implements Runnable{
	
	public static int WIDTH = 600;
	public static int HEIGHT = 400;
	
	private Window window;
	private boolean running = false;
	private Thread thread;
	private Handler handler;
	
	public Game(){
		setFocusable(true);
		window = new Window(WIDTH,HEIGHT,this);
		
	}
	
	public void init(){
		handler = new Handler();
		
		handler.addObject(new Player(50, 150, ID.Player, handler));
		handler.addObject(new Enemy(535, 150, ID.Enemy, handler));
		handler.addObject(new Ball(WIDTH/2, HEIGHT/2, ID.Ball,handler));
		addKeyListener(new KeyInput(handler));
		
	}
	
	public void tick(){
		handler.tick();
		
	}
	public void render(){
		
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		bs.show();
		g.dispose();
		
	}
	
	public void run(){
		init();
		
		int FPS = 60;
		double targetFPS = 1000000000 / FPS;
		double delta = 0;
		
		long lastTime = System.nanoTime();
		long now;
		long timer = System.currentTimeMillis();
		
		int ticks=0;
		int updates = 0;
		
		while(running){
			
			now = System.nanoTime();
			delta +=(now - lastTime ) / targetFPS;
			lastTime = now;
			
			if(delta>=1){
				tick();
				ticks++;
				delta--;
			}
			render();
			updates++;
			
			if(System.currentTimeMillis() - timer >= 1000){
				timer += 1000;
				System.out.println("FPS : " + ticks + "  - UPDATES : " + updates);
				ticks = 0;
				updates = 0;
			}
			
			
		}
		
		stop();
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this,"ThreadGame");
		thread.start();
		
	}
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String args[]){
		new Game().start();
	}

}
