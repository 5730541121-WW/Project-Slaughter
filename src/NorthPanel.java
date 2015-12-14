import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class NorthPanel extends JPanel {
	GameLogic logic;
	public static JLabel score = new JLabel();
	public static JLabel soul = new JLabel();

	public NorthPanel() {
		setPreferredSize(new Dimension(1400, 100));
		setLayout(new BorderLayout());
		score.setText("Score : 0");
		score.setFont(new Font("Tahoma", Font.BOLD, 30));
		soul.setText("Soul : 0");
		soul.setFont(new Font("Tahoma", Font.BOLD, 30));
		setBackground(Color.BLACK);
		score.setForeground(Color.WHITE);
		soul.setForeground(Color.WHITE);
		add(score, BorderLayout.WEST);
		add(soul, BorderLayout.EAST);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		int k = 0;
		for (int i = 0; i < GameLogic.getPlayer().getHp(); i++) {
			BufferedImage image = ResourceUtility.getHeart();
			g2d.drawImage(image, null, k + 400 - 125, 15);
			k += 70;
		}
		drawSkill(g2d);

	}

	public void drawSkill(Graphics2D g2d) {
		g2d.drawImage(ResourceUtility.getZicon(GameLogic.getPlayer().getCooldown()[0]), null, 700, 10);
		g2d.drawImage(ResourceUtility.getXicon(GameLogic.getPlayer().getCooldown()[1]), null, 810, 10);
		g2d.drawImage(ResourceUtility.getCicon(GameLogic.getPlayer().getCooldown()[2]), null, 920, 10);
		g2d.drawImage(ResourceUtility.getRicon(GameLogic.getPlayer().getRequiemDelay()), null, 1030, 10);
	}
}
