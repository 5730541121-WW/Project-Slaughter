import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Requiem extends Raze{
	public Requiem(int distance, int direction) {
		super(distance, direction);
	}
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		BufferedImage image = ResourceUtility.getRaze(tickCount);
		g2.drawImage(image,null, x-50, 230);
	}
}
