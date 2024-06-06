package pongProject2610;

import java.awt.Color;
import java.awt.Graphics;

public class Player1Bar extends Components {		

	// parametrized constructor 
	public Player1Bar (int positionX, int width, int length) {
		
		this.positionX=positionX;
		this.width=width;
		this.length=length;
	}
	
	// overriding paint method 
	@Override
	public void paint(Graphics g) {
	    g.setColor(Color.red);
	    g.fillRect(positionX, positionY, width, length);
	
	}
	
	// hit detection method
	public boolean HitDetection(Ball b1, Player1Bar p1) {
		if (b1.getX() > p1.getX() && b1.getX() < p1.getX()+width) {
			if (b1.getY() > p1.getY() && b1.getY() < p1.getY()+length) {
				return true;
			}
		}
		return false;
	}
	
	// methods for getting x and y valeus of p1 bar
	@Override
    public int getY(){
        return positionY;
    }


	@Override
    public int getX(){
        return positionX;
    }

    
    
	// move method, takes truth values from setUp and SetDown acceleration
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
	

