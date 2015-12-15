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
		setPreferredSize(new Dimension(500, 370));
		setLayout(null);
		AudioUtility.playTitle();
		JButton newgame = new JButton(new ImageIcon(ResourceUtility.button("ng")));
		newgame.setBorderPainted(false);
		newgame.setContentAreaFilled(false);
		newgame.setFocusPainted(false);
		newgame.setOpaque(false);
		JButton highscore = new JButton(new ImageIcon(ResourceUtility.button("hs")));
		highscore.setBorderPainted(false);
		highscore.setContentAreaFilled(false);
		highscore.setFocusPainted(false);
		highscore.setOpaque(false);
		newgame.addActionListener(new ActionListener() {

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
		add(newgame);
		newgame.setBounds(35, 250, 125, 35);
		add(highscore);
		highscore.setBounds(105, 310, 125, 35);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(ResourceUtility.getBg2(), null, 0, 0);
	}
}
