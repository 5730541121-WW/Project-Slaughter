import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sun.corba.se.impl.activation.ServerTableEntry;

import sun.invoke.empty.Empty;



public class TitleScreen extends JPanel {

	public TitleScreen() {
		//requestFocus();
		
		setPreferredSize(new Dimension(500, 370));
		//setLayout(new FlowLayout());	
		setLayout(null);
		JButton start = new JButton(new ImageIcon(ResourceUtility.button("ng")));
		start.setBorderPainted(false); 
		start.setContentAreaFilled(false); 
		start.setFocusPainted(false);
		start.setOpaque(false);
		
		
		JButton highscore = new JButton(new ImageIcon(ResourceUtility.button("hs")));
		highscore.setBorderPainted(false); 
		highscore.setContentAreaFilled(false); 
		highscore.setFocusPainted(false);
		highscore.setOpaque(false);
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InputUtility.mouseClickOnButton = true;
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
		start.setBounds(35, 250, 125, 35);
		//add(Box.createRigidArea(new Dimension(20, 0)));
		add(highscore);
		highscore.setBounds(105, 310, 125, 35);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(ResourceUtility.getBg2(), null, 0, 0);
	}
	
}
