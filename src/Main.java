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
		int i = JOptionPane.YES_OPTION;
		while( i == JOptionPane.YES_OPTION){
			i = RunThread.RunGame();
			//System.out.println(i);
			InputUtility.postUpdate();
			for(int j=0;j<256;j++)InputUtility.setKeyPressed(j, false);
		}
		System.exit(0);
	}

}
