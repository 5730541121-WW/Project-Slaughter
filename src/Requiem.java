import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Requiem extends Raze{
	public Requiem(int distance, int direction) {
		super(distance, direction);
	}
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.PINK);
		g2.fillOval(x-35, 365, 70, 70);
	}
}
