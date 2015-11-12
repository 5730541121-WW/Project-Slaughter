
public class Player {
	private int x,y;
	private int direction;
	private int hp;
	private boolean isDead;
	public Player(){
		direction = -1;
		x = 0;
		y = 0;
		hp = 3;
		isDead = false;
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
	public void decreaseLife(){
		if( this.hp <= 0 ) this.hp = 0;
		else this.hp--;
		if(hp == 0) GameLogic.setOver(true);
	}
}
