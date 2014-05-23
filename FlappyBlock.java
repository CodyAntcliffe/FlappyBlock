import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Need collision detection, Refreshing of the pipes/pipe object

import java.util.Random;

import javax.swing.*;

public class FlappyBlock extends JPanel implements MouseListener {
	
	//frame dimensions
	int height=600;//frame height
	int width=800;//frame width
	Pipes P=new Pipes();
	Pipes[] PY=new Pipes[5];
	//dimensions for flappy
	int blockyX=300;
	int blockyY=200;
	Color bgColor=Color.CYAN;
	Color blockyColor=Color.RED;
	Color pipeColor=Color.GREEN;
	int pipeX=width-100;
	int pipeY=0;
	
	flyUp up=new flyUp();
	flyDown down=new flyDown();
	Timer flyUpTimer=new Timer(10,up);
	Timer flyDownTimer=new Timer(10,down);
	int timerKeep=0;
	
	
	public FlappyBlock() {
		setDoubleBuffered(true);
		addMouseListener(this);
		setBackground(bgColor);
		setFocusable(true);
		setPreferredSize(new Dimension(width,height));
	}
	
	//causes flappy to ascend
	public class flyUp implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(timerKeep<14){
			P.topPipeX-=4;	
			P.bottomPipeX=P.topPipeX;
			blockyY-=6;
			timerKeep++;
			repaint();}
			if(timerKeep==14){
				flyUpTimer.stop();
				flyDownTimer.start();
				return;}
		}
	}
	
	//Causes flappy to descend
	public class flyDown implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(timerKeep>=10){
			P.topPipeX-=4;
			P.bottomPipeX=P.topPipeX;
			blockyY+=6;
			timerKeep++;
			repaint();}
			if(timerKeep==0){
				flyDownTimer.stop();
				timerKeep=0;
				return;}
		}
	}
	private int genRandomNum(){
		Random ran = new Random();
		int x = ran.nextInt(150) +50 ;
		return x;
	}
	
	private class Pipes{
		int topPipeX=width-100;
		int topPipeY=0;
		int topPipeHeight=genRandomNum();//controls how tall the top pipe will be
		
		int bottomPipeX=topPipeX;
		int bottomPipeY=topPipeHeight+170;//gives an opening between the pipes of 200
		int bottomPipeHeight=height;//will make the pipe touch the bottom of the frame
	}

	public void paintComponent(Graphics G){
		super.paintComponent(G);
		paintFlappy(G);
		paintPipes(G,P);
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
		G.fillRect(p.bottomPipeX, p.bottomPipeY, 100, P.bottomPipeHeight);
		G.fillRect(p.bottomPipeX-5, p.bottomPipeY, 110, 20);
		outlinePipes(G,p);
	
	}
	//Draws flappy
	private void paintFlappy(Graphics G){
		G.setColor(blockyColor);
		G.fillRect(blockyX,blockyY, 20, 20);
	}
	
	//When mouse is clicked
		public void mousePressed(MouseEvent evt)
		{
			if(evt.isMetaDown())
			{
			}
			else
				timerKeep=0;
				flyUpTimer.start();
				repaint();
		}

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
