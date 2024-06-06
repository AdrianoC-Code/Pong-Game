package pongProject2610;

import java.awt.*;

// abstract component class with necessary variables for the bar and ball classes
public abstract class Components {	
	
	// variables used across child classes
	int positionX;
	int positionY;
	int width;
	int length;
	int speed = 2;
	int ChangeInY = 3;
	int ChangeInX = 3;	
	
	boolean upAccel, downAccel;
	int BarPosition= 225;
	

	// abstract paint method for the shapes sizes and colours of objects
	public abstract void paint(Graphics g);
	
	// abstract method implemented in each child class to access X and Y values
    public abstract int getY();

    public abstract int getX();
}
	

