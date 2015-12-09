import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;


public class GameScreen extends JComponent{
	GameLogic logic = new GameLogic();
	public GameScreen(GameLogic logic){
		setPreferredSize(new Dimension(1024, 400));
		this.logic = logic;
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				InputUtility.setKeyPressed(e.getKeyCode(), false);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(InputUtility.getKeyPressed(e.getKeyCode())==false)
					InputUtility.setKeyTriggered(e.getKeyCode(), true);
				InputUtility.setKeyPressed(e.getKeyCode(), true);
				
			}
		});
		setDoubleBuffered(true);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for( Monster m : logic.getMonsters()){
			m.draw(g);
		}
		logic.getPlayer().draw(g);
		for( Raze r : logic.getRazes()){
			r.draw(g);
		}
	}
}
