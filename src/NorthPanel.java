import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class NorthPanel extends JPanel{
	GameLogic logic;
	public static JLabel score = new JLabel();
	public NorthPanel(){
		setPreferredSize(new Dimension(1024, 100));
		
		score.setText("Score : 0");
		score.setFont(new Font("Tahoma", Font.BOLD, 30));
		setBackground(Color.BLACK);
		score.setForeground(Color.WHITE);
		add(score);
	}
}
