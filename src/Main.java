import java.awt.BorderLayout;
import java.nio.ByteOrder;

import javax.swing.*;
import java.lang.Thread;
public class Main {
	public static JFrame f;
	public static NorthPanel north;
	public static GameScreen screen;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		f = new JFrame("Shadow Rage");		
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		north = new NorthPanel();
		screen = new GameScreen();
		f.add(north,BorderLayout.NORTH);
		f.add(screen,BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
		/*game = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				logic = new GameLogic();
				screen = new GameScreen(logic);
				north = new NorthPanel();
				f.add(north,BorderLayout.NORTH);
				f.add(screen,BorderLayout.CENTER);
				f.pack();
				f.setVisible(true);
				
				while(true){					
					screen.requestFocus();
					try {
						Thread.sleep(50);
					}catch(InterruptedException e){}
					if(logic.isOver()){
						HighScoreUtility.recordHighScore(logic.getPlayer().getScore());
						HighScoreUtility.displayTop10();
						System.exit(0);
					}
					logic.logicUpdate();
					f.repaint();
					north.score.setText("SCORE : "+GameLogic.getPlayer().getScore());
					north.soul.setText("SOUL : "+GameLogic.getPlayer().getSoulCount());
					InputUtility.postUpdate();
				}
			}
		};
		new Thread(game).start();*/
		
	}

}
