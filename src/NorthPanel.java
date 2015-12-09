import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class NorthPanel extends JPanel{
	GameLogic logic;
	public static JLabel score = new JLabel();
	public NorthPanel(){
		setPreferredSize(new Dimension(1024, 100));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		score.setText("Score : 0");
		score.setHorizontalAlignment(SwingConstants.LEFT);
		score.setFont(new Font("Tahoma", Font.BOLD, 30));
		setBackground(Color.BLACK);
		score.setForeground(Color.WHITE);
		add(score);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		int k = 450;
		for(int i=0;i<GameLogic.getPlayer().getHp();i++){
			g2d.fillRect(k, 5, 30,30);
			k+=50;
		}
	}
}
