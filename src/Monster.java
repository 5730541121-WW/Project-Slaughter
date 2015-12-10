import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

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
			direction = 1;
		}
		else {
			x = 1400;
			direction = -1;
		}
		y = 335;
		isDead = false;
		speed = (int)((Math.random())*5+5);
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
		if( direction == 1 )
			x+=speed;
		else
			x-=speed;
	}
	public void hit(){
		GameLogic.getPlayer().increaseSoul();
		GameLogic.getPlayer().increaseScore();
		isDead = true;
	}
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if(direction == 1){
			BufferedImage image = ResourceUtility.getCreepL((GameLogic.getTick()%14)/2);
			g2.drawImage(image, null, x-60, y);
		}
		else {
			BufferedImage image = ResourceUtility.getCreepR((GameLogic.getTick()%14)/2);
			g2.drawImage(image, null, x-60, y);
		}
		
	}
	public boolean isInSamePosition( IRenderable e ){
		if(e.getX() == x) return true;
		if(e.getX()>x && e.getX()-30<=x) return true;
		if(e.getX()<x && e.getX()+30>=x) return true;
		return false;
	}
	public boolean isRazeHit( Raze e ){
		if(e.getX() == x) return true;
		if(e.getX()>x && e.getX()-35<=x) return true;
		if(e.getX()<x && e.getX()+35>=x) return true;
		return false;
	}
}
