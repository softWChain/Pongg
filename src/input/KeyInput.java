package input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import framework.GameObject;
import framework.Handler;
import framework.ID;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		
		for(int i=0;i<handler.object.size();i++){
			GameObject temp = handler.object.get(i);
			if(temp.getId() == ID.Player){
				if(e.getKeyCode() == KeyEvent.VK_W){
					handler.setUp(true);
				}
				if(e.getKeyCode() == KeyEvent.VK_S){
					handler.setDown(true);
				}
			}
		}
		
	}
	public void keyReleased(KeyEvent e){
		
		for(int i=0;i<handler.object.size();i++){
			GameObject temp = handler.object.get(i);
			if(temp.getId() == ID.Player){
				if(e.getKeyCode() == KeyEvent.VK_W){
					handler.setUp(false);
				}
				if(e.getKeyCode() == KeyEvent.VK_S){
					handler.setDown(false);
				}
			}
		}
		
	}

}
