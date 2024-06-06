package pongProject2610;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;

public class Ball extends Components{

	// parameterized constructor
	public Ball (int positionX, int positionY, int width, int length) {
		this.positionX=positionX;
		this.positionY=positionY;
		this.width=width;
		this.length=length;	
	}
	
	// paint method, overriden to make white circle with different dimensions
	@Override
	public void paint(Graphics g) {
	    g.setColor(Color.white);
	    g.fillOval(positionX, positionY, width, length);
	}
	
	// change position of the ball by 3 in X and Y
    public void moveBall(){
        positionX += ChangeInX;
        positionY += ChangeInY;
    }
	
	
    // methods that make changes in X or Y negative so ball position can move left and up when bouncing
    public void oppositeX(){
        ChangeInX = ChangeInX * (-1);
    }
    public void oppositeY(){
        ChangeInY = ChangeInY * (-1);
    }
    
    
    // positionY is greater than bottom of screen (number of pixels > than screen pixels) call opposite to reverse Y
    // same with X
    public void bounceOffEdges(int TopOfScreen, int BottomOfScreen){
        //if the y value is at the bottom of the screen
        if (positionY > BottomOfScreen ){
            oppositeY();
        }
        //if y value is at top of screen
        else if(positionY < TopOfScreen){
            oppositeY();
        }


    }
    
    
    // methods to see X and Y values
	@Override
    public int getY(){
        return positionY;
    }


	@Override
    public int getX(){
        return positionX;
    }
    
    // reset after a point scored, pause for a bit to allow players a short reaction time
    public void resetBall(){
        //pause for a second
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    	positionX=320;
    	positionY=240;
    }
    
    // pause method to stop game 
	public void pause() {
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


 }
