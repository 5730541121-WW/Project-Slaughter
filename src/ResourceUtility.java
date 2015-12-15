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
	private static final BufferedImage dl = getImage("res/CREEP/doraL.png");
	private static final BufferedImage dr = getImage("res/CREEP/doraR.png");
	private static final BufferedImage nl = getImage("res/CREEP/nyanL.png");
	private static final BufferedImage nr = getImage("res/CREEP/nyanR.png");
	private static final BufferedImage zicon = getImage("res/SKILL/Zicon.png");
	private static final BufferedImage ziconcd = getImage("res/SKILL/Ziconcd.png");
	private static final BufferedImage xicon = getImage("res/SKILL/Xicon.png");
	private static final BufferedImage xiconcd = getImage("res/SKILL/Xiconcd.png");
	private static final BufferedImage cicon = getImage("res/SKILL/Cicon.png");
	private static final BufferedImage ciconcd = getImage("res/SKILL/Ciconcd.png");
	private static final BufferedImage ricon = getImage("res/SKILL/Ricon.png");
	private static final BufferedImage riconcd = getImage("res/SKILL/Riconcd.png");
	private static final BufferedImage ros = getImage("res/SF/ROS.png");
	private static final BufferedImage bg = getImage("res/BG/bg.jpg");
	private static final BufferedImage bg2 = getImage("res/BG/bg2.jpg");
	private static final BufferedImage doraBg = getImage("res/BG/doraBg.jpg");
	private static final BufferedImage nyanBg = getImage("res/BG/nyanBg.jpg");
	private static final BufferedImage hs = getImage("res/button/hs.png");
	private static final BufferedImage ng = getImage("res/button/ng.png");
	private static final BufferedImage tg = getImage("res/CREEP/tango.png");
	private static final BufferedImage freeze = getImage("res/CREEP/freeze.png");

	public static BufferedImage getTg() {
		return tg;
	}

	public static BufferedImage getBg2() {
		return bg2;
	}

	

	public static BufferedImage getBg() {
		return bg;
	}

	public static BufferedImage getDoraBg() {
		return doraBg;
	}

	public static BufferedImage getNyanBg() {
		return nyanBg;
	}

	public static BufferedImage getROS(int frame) {
		return ros.getSubimage(frame * 333, 0, 333, 200);
	}

	public static BufferedImage getZicon(int cd) {
		if (cd == 0)
			return zicon;
		else
			return ziconcd;
	}

	public static BufferedImage getXicon(int cd) {
		if (cd == 0)
			return xicon;
		else
			return xiconcd;
	}

	public static BufferedImage getCicon(int cd) {
		if (cd == 0)
			return cicon;
		else
			return ciconcd;
	}

	public static BufferedImage getRicon(int cd) {
		if (cd == 0)
			return ricon;
		else
			return riconcd;
	}

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

	public static BufferedImage getCreepL(int type, int frame) {
		if (type == 3)
			return dl.getSubimage(frame * 120, 0, 120, 120);
		if (type == 2)
			return nl.getSubimage(frame * 120, 0, 120, 120);
		return cl.getSubimage(frame * 120, 0, 120, 120);
	}

	public static BufferedImage getRaze(int frame) {
		return raze.getSubimage(frame * 100, 0, 100, 220);
	}

	public static BufferedImage getCreepR(int type, int frame) {
		if (type == 3)
			return dr.getSubimage(frame * 120, 0, 120, 120);
		if (type == 2)
			return nr.getSubimage(frame * 120, 0, 120, 120);
		return cr.getSubimage(frame * 120, 0, 120, 120);
	}

	public static BufferedImage getFreeze() {
		return freeze;
	}

	public static BufferedImage button(String s) {
		if (s.equalsIgnoreCase("ng"))
			return ng;
		if (s.equalsIgnoreCase("hs"))
			return hs;
		else
			return null;
	}
}
