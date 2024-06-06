/**
 * 
 */
package pongProject2610;

import java.awt.event.*;
import javax.swing.*;

/**
 * @author adri
 *
 */
// extends JFrame to make GUI
@SuppressWarnings("serial")
public class Pong extends JFrame  {


	/**
	 * @param args
	 */
	
	// creating the GUI 
    static JFrame pong = new JFrame("Pong"); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		pong.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close on exit 
		pong.setSize(800,600); // sets size
		pong.setResizable(false); // stops size being changed
				
		// adding the JPanel with all the painted objects 
		GameCompiled game = new GameCompiled();
		pong.add(game);	
		pong.setVisible(true); // opens the window
	

	    
	 //make a new swing Timer
    Timer refreshpage = new Timer(12, new ActionListener() {
        public void actionPerformed(ActionEvent e) {

        	
        	// gameLogic is what powers movement, action and the rules of the game
        	// repaint refreshes the window to SHOW that movement
            game.gameLogic();
        	game.repaint();


        }
    });
    refreshpage.start();


		}
	}




