import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongProgram implements ActionListener, KeyListener, MouseMotionListener{
	// Properties
	JFrame theframe;
	PongPanel thepanel;
	Timer thetimer;
	JLabel score1;
	JLabel score2;
	
	// Methods
	public void actionPerformed(ActionEvent evt){ 
		if(evt.getSource() == thetimer){ // If timer is triggered, it will repaint.
				thepanel.repaint();
		}
	}
	
	public void keyReleased(KeyEvent evt){ // keyReleased is triggered when you release the key.
		if(evt.getKeyCode() == 38){ // Up Arrow Key
			thepanel.blnPaddle1Up = false;
		}
		else if(evt.getKeyCode() == 40){ // Down Arrow Key
			thepanel.blnPaddle1Down = false;
		}
	}
	public void keyPressed(KeyEvent evt){ // keyPressed is triggered when you press the key.
		if(evt.getKeyCode() == 38){ // Up Arrow Key
			thepanel.blnPaddle1Up = true;
		}
		else if(evt.getKeyCode() == 40){ // Down Arrow Key
			thepanel.blnPaddle1Down = true;
		}
	}
	public void keyTyped(KeyEvent evt){ // keyTyped is triggered when you press and release the key. (Note: Laggy because it's typed)
		//
	}
	
	// This is an overridden method for MouseMotionListener
	public void mouseMoved(MouseEvent evt){
		thepanel.intPaddleY2 = evt.getY(); // Set object Y-Coordinate to Mouse Y-Coordinate
	}
	public void mouseDragged(MouseEvent evt){
		// 
	}
	
	// Constructors
	public PongProgram(){
		theframe = new JFrame("Pong");
		thepanel = new PongPanel();
		thepanel.setLayout(null);
		thepanel.setPreferredSize(new Dimension(1280, 720));
		thepanel.addMouseMotionListener(this); // Add MouseMotionListener
		
		theframe.addKeyListener(this); // Add KeyListener
		theframe.setContentPane(thepanel);
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.pack();
		theframe.setVisible(true);
		
		// Timer Object
		thetimer = new Timer(1000/60, this); // Triggering timer every 1000/60. Basically 60 FPS.
		thetimer.start();
		
		// Label Object
		 score1 = new JLabel("0"); // Initilize the JLabel String to "0"
		 score1.setSize(100, 100);
		 score1.setLocation(500, 150);
	
		 score2 = new JLabel("0"); // Initilize the JLabel String to "0"
		 score1.setSize(100, 100);
		 score1.setLocation(780, 150);
	
		 
	}
	
	// Main Methods
	public static void main(String[] args){
		new PongProgram();
	}
}

