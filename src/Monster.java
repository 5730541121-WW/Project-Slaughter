import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Monster implements IRenderable{
	private int x,y;
	private int direction;
	private int hp;
	private boolean isDead;
	private int speed;
	public Monster(){
		x = (int)((Math.random())*2);
		if( x < 1 ){
			x = 0;
			direction = -1;
		}
		else {
			x = 1100;
			direction = 1;
		}
		y = 300;
		isDead = false;
		speed = (int)((Math.random())*15+2);
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
		//GameLogic.getPlayer().decreaseLife();
		GameLogic.getPlayer().increaseScore();
		isDead = true;
	}
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLUE);
		g2.fillOval(x-20, y, 40, 40);	
		
	}
	public boolean isInSamePosition( IRenderable e ){
		if(e.getX() == x) return true;
		if(e.getX()>x && e.getX()<x+40) return true;
		if(x>e.getX() && x< e.getX()+40) return true;
		return false;
	}
}
