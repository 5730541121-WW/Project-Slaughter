
public class Monster {
	private int x,y;
	private int direction;
	private int hp;
	private boolean isDead;
	private String word;
	private int speed;
	public Monster(String word){
		x = (int)(Math.random());
		if( x < 0.5 ){
			x = 0;
			direction = -1;
		}
		else {
			x = 1024;
			direction = 1;
		}
		y = 360;
		isDead = false;
		this.word = word;
		speed = (int)((Math.random())*5+2);
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
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
	public void update(){
		if( direction == -1 )
			x+=speed;
		else
			x-=speed;
	}
	public void hit(){
		GameLogic.getPlayer().decreaseLife();
		isDead = true;
	}
}
