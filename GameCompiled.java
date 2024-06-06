package pongProject2610;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GameCompiled extends JPanel implements KeyListener {
	
  // variables and objects	
    final int widthW = 750, heightW = 550;
    Player1Bar p1;
    Player2Bar p2;
    Ball b1;
        
    int score1=0;
    int score2=0;
    
    // constructor 
    public GameCompiled() {

        //Make the ball and bars
        p1 = new Player1Bar(20, 10, 100);
        p2 = new Player2Bar(730, 10, 100);
        b1 = new Ball(320, 240, 10, 10);
        

       setFocusable(true);
       requestFocusInWindow();
      }
    
    
    public void paint(Graphics g) {
        // draw the background
    	g.setColor(Color.black);
        g.fillRect(0, 0, widthW, heightW);


        // draw the ball, bars and score
        b1.paint(g);
        p1.paint(g);
        p2.paint(g);
        g.drawString("Player 1 Score: " + score1 + "         Player 2 Score: " + score2, 220, 20);

    } 
    
    // the method that contains all the rules of the game
    public void gameLogic() {   	
    	this.addKeyListener(this);


        //calls the move ball method to update X and Y positions 
    	// .move is for bars going up and down
        b1.moveBall();      
        p1.move();
        p2.move();
               
        //calls bouceOffEdges method in Ball class that inverts Y direction if it hits the top or bottom of the screen
        b1.bounceOffEdges(0, heightW);
        
        
        // the hit detection of the bars and ball. if true, inverse X direction 
        if (p1.HitDetection(b1, p1)) {
        	b1.oppositeX();
        }
        if (p2.HitDetection(b1, p2)) {
        	b1.oppositeX();
        }
        	
        
        // if x value of ball less than position of the bar, score up and reset ball to middle
    	if (b1.getX() < 0) {
    		score2+=1;
            b1.oppositeX();
    		b1.resetBall();
    	}
    	else if (b1.getX() > widthW) {
    		score1+=1;
            b1.oppositeX();
    		b1.resetBall();
    	}   

    }
    

    
    
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	// key pressed to move bar up and down
	// also a pause button
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W) {
			p1.setUpAccel(true);
		}
		else if(e.getKeyCode()==KeyEvent.VK_S) {
			p1.setDownAccel(true);
		}
		else if (e.getKeyCode()==KeyEvent.VK_UP) {
			p2.setUpAccel(true);
		}
		else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			p2.setDownAccel(true);

		}
		else if (e.getKeyCode()==KeyEvent.VK_P) {
			b1.pause();
		}
		
	}

	// key released to signal that bar can stop moving 
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W) {
			p1.setUpAccel(false);
		}
		else if(e.getKeyCode()==KeyEvent.VK_S) {
			p1.setDownAccel(false);
		}
		else if (e.getKeyCode()==KeyEvent.VK_UP) {
			p2.setUpAccel(false);
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			p2.setDownAccel(false);
			
		} 
	
	} 
	
		

}
