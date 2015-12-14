import java.awt.BorderLayout;
import java.nio.ByteOrder;

import javax.swing.*;
import java.lang.Thread;
public class Main {
	public static JFrame f;
	public static NorthPanel north;
	public static GameScreen screen;
	public static TitleScreen title;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameLogic logic = new GameLogic();
		f = new JFrame("Shadow Rage");	
		f.setResizable(false);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		north = new NorthPanel();
		screen = new GameScreen();
		title = new TitleScreen();		
		f.add(title);
		f.pack();
		f.setVisible(true);		
		while(!InputUtility.mouseClick){
			title.requestFocus();
		}
		f.remove(title);
		AudioUtility.playBG();
		f.add(north,BorderLayout.NORTH);
		f.add(screen,BorderLayout.CENTER);
		f.validate();
		f.pack();
		
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