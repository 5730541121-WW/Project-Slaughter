import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.sun.glass.events.KeyEvent;

public class Player implements IRenderable {
	private int x, y;
	private int direction;
	private int soulCount;
	private boolean isRequiemUnleashing;
	private int RequiemStage;
	private int requiemTickCount;
	private int hp;
	private int score;
	private int razeTick;
	private boolean isDead, isRazing;

	public boolean isRazing() {
		return isRazing;
	}

	public void setRazing(boolean isRazing) {
		this.isRazing = isRazing;
	}

	private static int[] cooldown = new int[4];
	private boolean isRequiemStart;
	private int startingX;
	private static int RequiemDelay;
	
	public static int getRequiemDelay() {
		return RequiemDelay;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public static int[] getCooldown() {
		return cooldown;
	}

	public Player() {
		direction = -1;
		x = 700;
		y = 240;
		hp = 3;
		isDead = false;
		score = 0;
		cooldown[0] = cooldown[1] = cooldown[2] = 0;
		soulCount = 10;
		isRequiemUnleashing = false;
		RequiemStage = 1;
		requiemTickCount = 0;
		isRazing = false;
		razeTick = 0;
		isRequiemStart = false;
		RequiemDelay = 0;
	}

	public int getSoulCount() {
		return soulCount;
	}

	public void setSoulCount(int soulCount) {
		this.soulCount = soulCount;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void decreaseLife() {
		if (this.hp <= 0)
			this.hp = 0;
		else
			this.hp--;
		if (hp == 0)
			GameLogic.setOver(true);
	}

	public void increaseScore() {
		score += 25;
	}

	public void update() {
		if (isRequiemReady() && InputUtility.getKeyTriggered(KeyEvent.VK_R)) {
			isRequiemStart = true;
			soulCount = 0;
			startingX = x;
			AudioUtility.playSound("ros");
			RequiemDelay = 0;
		} else if (isRequiemStart && !isRequiemUnleashing) {
			RequiemDelay++;
			if (RequiemDelay == 30) {
				isRequiemUnleashing = true;
				isRequiemStart = false;
				RequiemDelay = 0;
			}
		} else if (isRequiemUnleashing) {
			soulCount = 0;
			if (requiemTickCount == 2 && (RequiemStage * 50 + startingX <= 1400 || startingX - RequiemStage * 50 >= 0)) {
				GameLogic.getRazes().add(new Requiem(RequiemStage * 50, 1));
				GameLogic.getRazes().add(new Requiem(RequiemStage * 50, -1));
				requiemTickCount = 0;
				RequiemStage++;
			} else if (RequiemStage * 50 + startingX > 1400 && startingX - RequiemStage * 50 < 0) {
				isRequiemUnleashing = false;
				RequiemStage = 1;
			} else
				requiemTickCount++;
		} else if (InputUtility.getKeyTriggered(KeyEvent.VK_C) && cooldown[2] == 0)

		{
			startingX = x;
			GameLogic.getRazes().add(new Raze(600, direction));
			AudioUtility.playSound("raze");
			isRazing = true;
			razeTick = 7;
			cooldown[2] = 60;
		} else if (InputUtility.getKeyTriggered(KeyEvent.VK_X) && cooldown[1] == 0)

		{
			startingX = x;
			GameLogic.getRazes().add(new Raze(400, direction));
			AudioUtility.playSound("raze");
			isRazing = true;
			razeTick = 7;
			cooldown[1] = 60;
		} else if (InputUtility.getKeyTriggered(KeyEvent.VK_Z) && cooldown[0] == 0)

		{
			startingX = x;
			GameLogic.getRazes().add(new Raze(200, direction));
			AudioUtility.playSound("raze");
			isRazing = true;
			razeTick = 7;
			cooldown[0] = 60;
		} if (InputUtility.getKeyPressed(KeyEvent.VK_RIGHT) && !isRazing && RequiemDelay == 0)

		{
			x += 15;
			direction = 1;
			if (x >= 1400)
				x = 1400;
		} else if (InputUtility.getKeyPressed(KeyEvent.VK_LEFT) && !isRazing && RequiemDelay == 0)

		{
			x -= 15;
			direction = -1;
			if (x <= 0)
				x = 0;
		}
		if (razeTick > 0)
			razeTick--;
		else
			isRazing = false;
		for (int i = 0; i < 3; i++)

		{
			if (cooldown[i] > 0) {
				cooldown[i] -= 1;
				// System.out.println(cooldown[i]);
			}
		}

	}

	public int getStartingX() {
		return startingX;
	}

	public void setStartingX(int startingX) {
		this.startingX = startingX;
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if(RequiemDelay>0){
			BufferedImage image = ResourceUtility.getROS(RequiemDelay/2);
			g2d.drawImage(image, null, x-140, y);
			return;
		}
		if (isRazing) {
			if (razeTick > 3) {
				if (direction == 1) {
					BufferedImage image = ResourceUtility.getRr1();
					g2d.drawImage(image, null, x - 140, y);
				} else {
					BufferedImage image = ResourceUtility.getRl1();
					g2d.drawImage(image, null, x - 140, y);
				}
			} else {
				if (direction == 1) {
					BufferedImage image = ResourceUtility.getRr2();
					g2d.drawImage(image, null, x - 140, y);
				} else {
					BufferedImage image = ResourceUtility.getRl2();
					g2d.drawImage(image, null, x - 140, y);
				}
			}
			return;
		}
		if (GameLogic.getTick() % 6 < 3) {
			if (direction == 1) {
				BufferedImage image = ResourceUtility.getNr1();
				g2d.drawImage(image, null, x - 140, y);
			} else {
				BufferedImage image = ResourceUtility.getNl1();
				g2d.drawImage(image, null, x - 140, y);
			}
		} else {
			if (direction == 1) {
				BufferedImage image = ResourceUtility.getNr2();
				g2d.drawImage(image, null, x - 140, y);
			} else {
				BufferedImage image = ResourceUtility.getNl2();
				g2d.drawImage(image, null, x - 140, y);
			}
		}
	}

	public boolean isRequiemReady() {
		if (soulCount >= 10)
			return true;
		return false;
	}

	public void increaseSoul() {
		soulCount++;
	}
}
