import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Visage implements IRenderable {
	private int x, y, tick;

	public Visage() {
		x = 1400;
		y = 10;
		tick = 0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void increaseTick() {
		tick++;
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		BufferedImage image = ResourceUtility.getVisage((tick / 2) % 4);
		g2.drawImage(image, null, x, y);

	}

}
