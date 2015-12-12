import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Background {
	BufferedImage image;
	private int tick;
	public Background(){
		image = ResourceUtility.getBg();
	}
	public void draw(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, null, 0, 0);
	}
}
