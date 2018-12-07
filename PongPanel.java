import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class PongPanel extends JPanel{
	// Properties
	int intPaddleY1 = 300;
	int intPaddleY2 = 300;
	int intBallX = 640;
	int intBallY = 360;
	int intScore1 = 0;
	int intScore2 = 0;
	boolean blnPaddle1Down;
	boolean blnPaddle1Up;
	boolean blnPaddle2Down;
	boolean blnPaddle2Up;
	boolean blnBallRight = false;
	boolean blnBallLeft = true;
	boolean blnBallUp = false;
	boolean blnBallDown = true;
	
	// Methods
	public void paintComponent(Graphics g){
		// Set Background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1280, 720); 
		
		// Paddle 1 
		g.setColor(Color.WHITE);
		g.fillRect(5, intPaddleY1, 10, 100 ); 
		if(blnPaddle1Down){ // Translation movement of Paddle 1 using Boolean.
			intPaddleY1 = intPaddleY1 + 40;
		}
		if(blnPaddle1Up){
			intPaddleY1 = intPaddleY1 - 40;
		}
		if(intPaddleY1 < 0){ // Restrict Paddle1 Movement
			intPaddleY1 = intPaddleY1 + 40;
		}
		if(intPaddleY1 > 620){
			intPaddleY1 = intPaddleY1 - 40;
		}
		
		// Paddle 2
		g.setColor(Color.WHITE);
		g.fillRect(1265, intPaddleY2, 10, 100); 
		if(blnPaddle2Down){ // Translation movement of Paddle 2 using Boolean.
			intPaddleY2 = intPaddleY2 + 20;
		}
		if(blnPaddle2Up){
			intPaddleY2 = intPaddleY2 - 20;
		}
		if(intPaddleY2 < 0){
			intPaddleY2 = 0;
		}
		if(intPaddleY2 > 620){
			intPaddleY2 = 620;
		}
		
		// Ball
		g.setColor(Color.WHITE);
		g.fillOval(intBallX, intBallY, 20, 20);
		if(blnBallLeft == true){ // Ball Left
			intBallX = intBallX - 5;
		}
		if(blnBallRight == true){ // Ball Right
			intBallX = intBallX + 5;
		}
		if(blnBallUp == true){ // Ball Up
			intBallY = intBallY - 5;
		}
		if(blnBallDown == true){ // Ball Down
			intBallY = intBallY + 5;
		}
		
		if(intBallX < 0){ // Left Wall - End Game
			intScore1 = intScore1 + 1;
			intBallX = 640;
			intBallY = 360;
			blnBallRight = false;
			blnBallLeft = true;
			blnBallUp = false;
			blnBallDown = true;
		}
		if(intBallX > 1280){ // Right Wall - End Game
			intScore2 = intScore2 + 1;
			intBallX = 640;
			intBallY = 360;
			blnBallRight = false;
			blnBallLeft = true;
			blnBallUp = false;
			blnBallDown = true;
		}
		if(intBallY == 0){ // Top Wall
			blnBallUp = false;
			blnBallDown = true;
		}
		if(intBallY == 700){ // Bottom Wall
			blnBallDown = false;
			blnBallUp = true;
		}
		if(intBallY >= intPaddleY1 && intBallY <= intPaddleY1 + 100 && intBallX == 15){ // Paddle 1
			blnBallLeft = false;
			blnBallRight = true;
		}
		if(intBallY >= intPaddleY2 && intBallY <= intPaddleY2 + 100 && intBallX == 1255){ // Paddle 2
			blnBallRight = false;
			blnBallLeft = true;
		}
	}
	
	// Constructors
	public PongPanel(){
		super();
	}
	
	
}

