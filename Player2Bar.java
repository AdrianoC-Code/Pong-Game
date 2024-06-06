package pongProject2610;

import java.awt.*;

public class Player2Bar extends Components {
	
	// same thing as Player1Bar class mostly, with a few tweaks taking p2 values as inputs
	public Player2Bar (int positionX, int width, int length) {
		this.positionX=positionX;
		this.width=width;
		this.length=length;
	}
	
	@Override
	public void paint(Graphics g) {
	    g.setColor(Color.blue);
	    g.fillRect(positionX, positionY, width, length);
	    
	}

		
    public boolean HitDetection(Ball b1, Player2Bar p2) {
    	if (b1.getX() > p2.getX() && b1.getX() < p2.getX()+width) {
    		if (b1.getY() > p2.getY() && b1.getY() < p2.getY()+length) {
    			return true;
    		}
    	}
    		return false;
   	}
        	
	@Override
    public int getY(){
        return positionY;
    }


	@Override
    public int getX(){
        return positionX;
    }
	
	
	public void move() {
		if(upAccel) {
			BarPosition-=3;
		}
		else if (downAccel) {
			BarPosition+=3;
		}
		positionY=BarPosition;						
	}
	
	public void setUpAccel(boolean input) {
		upAccel = input;
	}
	
	public void setDownAccel(boolean input) {
		downAccel = input;
	}

	
}
