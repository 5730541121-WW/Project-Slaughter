import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.sun.glass.events.KeyEvent;

public class Player implements IRenderable {
	private int x, y;
	private int direction;
	private int hp;
	private int score;
	private boolean isDead;
	private int[] cooldown = new int[4];

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int[] getCooldown() {
		return cooldown;
	}

	public void setCooldown(int[] cooldown) {
		this.cooldown = cooldown;
	}

	public Player() {
		direction = -1;
		x = 500;
		y = 300;
		hp = 3;
		isDead = false;
		score = 0;
		cooldown[0]=cooldown[1]=cooldown[2]=0;
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
		if (InputUtility.getKeyTriggered(KeyEvent.VK_C) && cooldown[2] == 0) {
			GameLogic.getRazes().add(new Raze(400, direction));
			cooldown[2]=60;
		} else if (InputUtility.getKeyTriggered(KeyEvent.VK_X) && cooldown[1] == 0) {
			GameLogic.getRazes().add(new Raze(250, direction));
			cooldown[1]=60;
		} else if (InputUtility.getKeyTriggered(KeyEvent.VK_Z) && cooldown[0] == 0) {
			GameLogic.getRazes().add(new Raze(100, direction) );
			cooldown[0]=60;
		}
		else if (InputUtility.getKeyPressed(KeyEvent.VK_RIGHT)) {
			x += 10;
			direction = 1;
			if (x >= 1024 - 30)
				x = 1024 - 30;
		} else if (InputUtility.getKeyPressed(KeyEvent.VK_LEFT)) {
			x -= 10;
			direction = -1;
			if (x <= 0)
				x = 0;
		} 
		for(int i=0;i<3;i++){
			if(cooldown[i]>0){
				cooldown[i]-=1;
				//System.out.println(cooldown[i]);
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		g2.fillRect(x, y - 90 + 40, 40, 90);

	}
}
