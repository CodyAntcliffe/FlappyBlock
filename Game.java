import java.awt.EventQueue;

import javax.swing.JFrame;
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
public class Game extends JFrame {

	public Game(){
		add(new FlappyBlock());
		
		setTitle("FlappyBlock");
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
	JFrame ex=new Game();
	ex.setVisible(true);
		
	}
}
