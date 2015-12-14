import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import sun.security.jgss.LoginConfigImpl;

public class Monster implements IRenderable {
	private int x, y;
	private int direction;
	private int hp;
	private boolean isDead;
	private int speed;
	private int type;
	private boolean isFreeze;
	private int freezeTick = 0;

	public Monster() {
		x = (int) ((Math.random()) * 2);
		if (x < 1) {
			x = 0;
			direction = 1;
		} else {
			x = 1400;
			direction = -1;
		}
		y = 335;
		isDead = false;
		speed = (int) ((Math.random()) * 5 + 5);		
		if(GameLogic.isDora()){
			isFreeze = true;
			freezeTick = 175 - GameLogic.getDoraCount();
		}else{
			isFreeze = false;
			freezeTick = 0;
		}
		type = (int) (Math.random() * 100);
		// System.out.println(type);
		if (type % 5 == 0) {
			if (GameLogic.getPlayer().getHp() < 3 && type % 2 == 0)
				type = 1;
			else if (type % 3 == 0)
				type = 2;
			else
				type = 3;
		} else
			type = 0;
		//type = 3;
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

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public void setFreeze(boolean isFreeze) {
		this.isFreeze = isFreeze;
	}

	public void setFreezeTick(int freezeTick) {
		this.freezeTick = freezeTick;
	}

	public void update() {
		if (isFreeze) {
			x += direction * speed / 3;
			freezeTick--;
			if (freezeTick == 0)
				isFreeze = false;
		} else
			x += direction * speed;
	}

	public void hit() {
		GameLogic.getPlayer().increaseSoul();
		GameLogic.getPlayer().increaseScore();
		if (type == 1) {
			if (GameLogic.getPlayer().getHp() < 3)
				GameLogic.getPlayer().setHp(GameLogic.getPlayer().getHp() + 1);
		} else if (type == 2) {
			GameLogic.setNyan(true);
			GameLogic.setDora(false);
			GameLogic.setNyanCount(0);
			GameLogic.setDoraCount(0);
			GameLogic.getPlayer().setImmortal(true);
			GameLogic.getPlayer().setImmortalTick(100);
			AudioUtility.stopBG();
		} else if (type == 3) {
			GameLogic.setNyan(false);
			GameLogic.setDora(true);
			GameLogic.setNyanCount(0);
			GameLogic.setDoraCount(0);
			AudioUtility.stopBG();
			for (Monster m : GameLogic.getMonsters()) {
				if (m.equals(this))
					continue;
				m.setFreeze(true);
				m.setFreezeTick(175);
			}
		}
		isDead = true;
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if (direction == 1) {
			BufferedImage image = ResourceUtility.getCreepL(type,(GameLogic.getTick() % 14) / 2);
			g2.drawImage(image, null, x - 60, y);
		} else {
			BufferedImage image = ResourceUtility.getCreepR(type,(GameLogic.getTick() % 14) / 2);
			g2.drawImage(image, null, x - 60, y);
		}
		if(type == 1){
			BufferedImage image = ResourceUtility.getTango();
			g2.drawImage(image, null, x - 45, y);
		}
		if (isFreeze) {
			BufferedImage image = ResourceUtility.getFreeze();
			g2.drawImage(image, null, x - 60, y);
		}

	}

	public boolean isInSamePosition(IRenderable e) {
		if (e.getX() == x)
			return true;
		if (e.getX() > x && e.getX() - 30 <= x)
			return true;
		if (e.getX() < x && e.getX() + 30 >= x)
			return true;
		return false;
	}

	public boolean isRazeHit(Raze e) {
		if (e.getX() == x) {
			if (type == 1)
				new SoundThread("heal").start();
			if (type == 2)
				new SoundThread("immortal").start();
			if (type == 3)
				new SoundThread("freeze").start();
			return true;
		}
		if (e.getX() > x && e.getX() - 35 <= x) {
			if (type == 1)
				new SoundThread("heal").start();
			if (type == 2)
				new SoundThread("immortal").start();
			if (type == 3)
				new SoundThread("freeze").start();
			return true;
		}
		if (e.getX() < x && e.getX() + 35 >= x) {
			if (type == 1)
				new SoundThread("heal").start();
			if (type == 2)
				new SoundThread("immortal").start();
			if (type == 3)
				new SoundThread("freeze").start();
			return true;
		}
		return false;
	}
}
