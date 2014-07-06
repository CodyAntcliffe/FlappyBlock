
import javax.swing.JFrame;

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
