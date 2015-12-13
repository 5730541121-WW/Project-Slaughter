import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Background {
	private static BufferedImage image = ResourceUtility.getBg();
	private static BufferedImage imageDora = ResourceUtility.getDoraBg();
	private static BufferedImage imageNyan = ResourceUtility.getNyanBg();
	private int tick;
	public static void draw(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		if(GameLogic.isDora())
			g2.drawImage(imageDora, null, 0, 0);
		else if(GameLogic.isNyan())
			g2.drawImage(imageNyan, null, 0, 0);
		else 
			g2.drawImage(image, null, -GameLogic.getPlayer().getX()/3, 0);
	}
}
