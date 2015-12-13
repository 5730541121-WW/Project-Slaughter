import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sun.corba.se.impl.activation.ServerTableEntry;

public class TitleScreen extends JPanel {

	public TitleScreen() {
		//requestFocus();
		
		setPreferredSize(new Dimension(1024, 768));
		setLayout(new FlowLayout());
		JButton start = new JButton("New Game");
		JButton highscore = new JButton("High Score");
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InputUtility.mouseClick = true;
			}
		});
		highscore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HighScoreUtility.displayTop10();
			}
		});
		/*
		 * south.setPreferredSize(new Dimension(1024, 100)); south.setLayout(new
		 * FlowLayout()); south.add(start); south.add(highscore);
		 * add(south,BorderLayout.SOUTH);
		 */
		add(start);
		add(Box.createRigidArea(new Dimension(20, 0)));
		add(highscore);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(ResourceUtility.getBg2(), null, 0, 0);
	}
	
}
