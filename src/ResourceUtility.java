import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceUtility {
	private static BufferedImage getImage(String directory) {
		/* fill code */
		ClassLoader loader = ResourceUtility.class.getClassLoader();
		try {
			return ImageIO.read(loader.getResource(directory));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return null;
		}
	}

	private static final BufferedImage nl1 = getImage("res/SF/nl1.png");
	private static final BufferedImage nl2 = getImage("res/SF/nl2.png");
	private static final BufferedImage nr1 = getImage("res/SF/nr1.png");
	private static final BufferedImage nr2 = getImage("res/SF/nr2.png");
	private static final BufferedImage rl1 = getImage("res/SF/rl1.png");
	private static final BufferedImage rl2 = getImage("res/SF/rl2.png");
	private static final BufferedImage rr1 = getImage("res/SF/rr1.png");
	private static final BufferedImage rr2 = getImage("res/SF/rr2.png");
	private static final BufferedImage raze = getImage("res/SF/raze.png");
	private static final BufferedImage heart = getImage("res/SF/heart.png");
	private static final BufferedImage cl = getImage("res/CREEP/creepL.png");
	private static final BufferedImage cr = getImage("res/CREEP/creepR.png");

	public static BufferedImage getHeart() {
		return heart;
	}

	public static BufferedImage getRl1() {
		return rl1;
	}

	public static BufferedImage getRl2() {
		return rl2;
	}

	public static BufferedImage getRr1() {
		return rr1;
	}

	public static BufferedImage getRr2() {
		return rr2;
	}

	public static BufferedImage getNl1() {
		return nl1;
	}

	public static BufferedImage getNl2() {
		return nl2;
	}

	public static BufferedImage getNr1() {
		return nr1;
	}

	public static BufferedImage getNr2() {
		return nr2;
	}

	public static BufferedImage getCreepL(int frame) {
		return cl.getSubimage(frame * 120, 0, 120, 120);
	}

	public static BufferedImage getRaze(int frame) {
		return raze.getSubimage(frame * 100, 0, 100, 220);
	}

	public static BufferedImage getCreepR(int frame) {
		return cr.getSubimage(frame * 120, 0, 120, 120);
	}
}
