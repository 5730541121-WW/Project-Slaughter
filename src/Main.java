import java.awt.BorderLayout;
import java.nio.ByteOrder;

import javax.swing.*;

public class Main {
	public static GameLogic logic;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logic = new GameLogic();
		JFrame f = new JFrame("Shadow Rage");		
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		GameScreen screen = new GameScreen(logic);
		NorthPanel north = new NorthPanel();
		f.add(north,BorderLayout.NORTH);
		f.add(screen,BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
		 
		while(true){
			screen.requestFocus();
			try {
				Thread.sleep(50);
			}catch(InterruptedException e){}
			//if(logic.isOver())return;
			logic.logicUpdate();
			f.repaint();
			north.score.setText("SCORE : "+GameLogic.getPlayer().getScore());
			//north.score.setHorizontalAlignment(SwingConstants.LEFT);
			InputUtility.postUpdate();
		}
	}

}
