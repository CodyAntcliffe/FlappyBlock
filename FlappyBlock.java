import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Need collision detection

import java.util.Random;

import javax.swing.*;

public class FlappyBlock extends JPanel implements MouseListener {
	
	//frame dimensions
	int windowHeight=600;//frame height
	int windowWidth=800;//frame width
	//Various colors used
	Color bgColor=Color.CYAN;
	Color blockyColor=Color.RED;
	Color pipeColor=Color.GREEN;
	
	Pipes[] PY=new Pipes[100];//holds our instance of pipes
	
	//Starting location for blocky
	int blockyX=300;
	int blockyY=200;
	int blockyDimensions=15;//sets size for blocky
	
	//These are used to control flying up and down
	flyUp up=new flyUp();
	flyDown down=new flyDown();
	Timer flyUpTimer=new Timer(10,up);
	Timer flyDownTimer=new Timer(10,down);
	int timerKeep=0;
<<<<<<< HEAD

	boolean gameOver=false; //checks if gameover
=======
	
>>>>>>> origin/master
	//constructor
	public FlappyBlock() {
		//initializes the pipes
		for(int i=0; i<PY.length;i++){
			PY[i]=new Pipes();
			PY[i].topPipeX=(windowWidth-100)+(i*250);
			PY[i].bottomPipeX=PY[i].topPipeX;
		}
		setDoubleBuffered(true);
		addMouseListener(this);
		setBackground(bgColor);
		setFocusable(true);
		setPreferredSize(new Dimension(windowWidth,windowHeight));
	}
<<<<<<< HEAD

=======
	
	public void drawPipes(Pipes[] PZ){
		
	}
>>>>>>> origin/master
	//causes flappy to ascend
	public class flyUp implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(timerKeep<14){
				for(int i=0;i<PY.length;i++)
					PY[i].movePipes();
			blockyY-=6;
			timerKeep++;
			collisionDetection();
			repaint();}
			if(timerKeep==14){
				flyUpTimer.stop();
				flyDownTimer.start();
				collisionDetection();
				
				return;}
		}
	}
	//Causes flappy to descend
		public class flyDown implements ActionListener{
			public void actionPerformed(ActionEvent event){
				if(timerKeep>=10){
					for(int i=0;i<PY.length;i++)
						PY[i].movePipes();
				blockyY+=6;
				timerKeep++;
<<<<<<< HEAD
				collisionDetection();
=======
>>>>>>> origin/master
				repaint();}
				if(timerKeep==0){
					flyDownTimer.stop();
					timerKeep=0;
<<<<<<< HEAD
					collisionDetection();
=======
>>>>>>> origin/master
					return;}
			}
		}
	//class for the pipe objects
	private class Pipes{
		int topPipeX=windowWidth-100;//States where to place first pipe on X-axis
		int topPipeY=0;
		int topPipeHeight=getRandomPipeHeight();//controls how tall the top pipe will be
		int bottomPipeX=topPipeX;
		int bottomPipeY=topPipeHeight+170;//gives an opening between the pipes of 200
		int bottomPipeHeight=windowHeight+20;//will make the pipe touch the bottom of the frame
		
		//Generates a random location for a pipe
		private int getRandomPipeHeight(){
			Random ran = new Random();
			int x = ran.nextInt(300) +50 ;
			return x;
		}
		
		//causes pipes to move, simulating movement by flappy
		public void movePipes(){
			this.topPipeX-=3;
			this.bottomPipeX-=3;
		
		}
	}//End class Pipes

	public void paintComponent(Graphics G){
		super.paintComponent(G);
		
		paintFlappy(G);
		for(int i=0;i<PY.length;i++)
		{
			paintPipes(G,PY[i]);
		}
<<<<<<< HEAD
		
=======
>>>>>>> origin/master
	}
	
	//Outlines the pipe in black lines to give it a more defined look
	private void outlinePipes(Graphics G, Pipes P){
		G.setColor(Color.BLACK);
		//outlines top pipe
		G.drawLine(P.topPipeX, P.topPipeY, P.topPipeX,  P.topPipeY+P.topPipeHeight-20);
		G.drawLine(P.topPipeX+100, P.topPipeY,P.topPipeX+100,  P.topPipeY+P.topPipeHeight-20);
		G.drawLine(P.topPipeX-5, P.topPipeY+P.topPipeHeight-20, P.topPipeX+105,  P.topPipeY+P.topPipeHeight-20);
		G.drawLine(P.topPipeX-5, P.topPipeY+P.topPipeHeight, P.topPipeX+105,  P.topPipeY+P.topPipeHeight);
		G.drawLine(P.topPipeX-5, P.topPipeY+P.topPipeHeight-20, P.topPipeX-5,  P.topPipeY+P.topPipeHeight);
		G.drawLine(P.topPipeX+105, P.topPipeY+P.topPipeHeight-20, P.topPipeX+105,  P.topPipeY+P.topPipeHeight);
		//outlines bottom pipe
		G.drawLine(P.bottomPipeX, P.bottomPipeY+20, P.bottomPipeX, P.bottomPipeHeight);
		G.drawLine(P.bottomPipeX+100, P.bottomPipeY+20,P.bottomPipeX+100, P.bottomPipeHeight);
		G.drawLine(P.bottomPipeX-5, P.bottomPipeY+20, P.bottomPipeX+105, P.bottomPipeY+20);
		G.drawLine(P.bottomPipeX-5, P.bottomPipeY, P.bottomPipeX+105, P.bottomPipeY);
		G.drawLine(P.bottomPipeX-5, P.bottomPipeY+20, P.bottomPipeX-5, P.bottomPipeY);
		G.drawLine(P.bottomPipeX+105, P.bottomPipeY+20, P.bottomPipeX+105, P.bottomPipeY);
	}
	//Draws a pipe 
	private void paintPipes(Graphics G, Pipes p){
		G.setColor(pipeColor);
		G.fillRect(p.topPipeX, p.topPipeY, 100, p.topPipeHeight);
		G.fillRect(p.topPipeX-5, p.topPipeHeight-20, 110, 20);		
		
		//Draws bottom pipe
		G.fillRect(p.bottomPipeX, p.bottomPipeY, 100, p.bottomPipeHeight);
		G.fillRect(p.bottomPipeX-5, p.bottomPipeY, 110, 20);
		outlinePipes(G,p);	
	}
	//Draws flappy
	private void paintFlappy(Graphics G){
		G.setColor(blockyColor);
		G.fillRect(blockyX,blockyY, blockyDimensions, blockyDimensions);
	}
	//When mouse is clicked
		public void mousePressed(MouseEvent evt)
		{
			if(evt.isMetaDown()&&gameOver==false)
			{
			}
			else if(gameOver==false)
				timerKeep=0;
				flyUpTimer.start();
				repaint();
		}

<<<<<<< HEAD
		//Collision Detection
		
		public void collisionDetection(){
			
			for(int i=0;i<100;i++){
				//topPipe detection
				if(blockyX+15>=PY[i].topPipeX&&blockyX+15<=PY[i].topPipeX+100 && blockyY>=PY[i].topPipeY &&blockyY<=(PY[i].topPipeY+PY[i].topPipeHeight))
				{
					gameOver=true;
					flyUpTimer.stop();
					flyDownTimer.stop();		
				}
				else if(blockyX+15>=PY[i].topPipeX&&blockyX+15<=PY[i].topPipeX+100 && blockyY>=PY[i].bottomPipeY-15 &&blockyY+15<=(PY[i].bottomPipeY-15+PY[i].bottomPipeHeight))
				{
					gameOver=true;
					flyUpTimer.stop();
					flyDownTimer.stop();
				}
			}	
		}
=======

>>>>>>> origin/master
		//suppresses a warning
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
