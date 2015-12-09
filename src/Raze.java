import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Raze implements IRenderable{
	private int distance;
	//private int value;
	private boolean isVisible;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	private int tickCount;
	private int x;
	public Raze(int distance,int direction){
		this.distance = distance;
		x = direction*distance + GameLogic.getPlayer().getX();
		tickCount = 3;
		isVisible = true;
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.GREEN);
		g2.fillOval(x-20, 300, 40, 40);
	}
	public void update(){
		if(tickCount == 0) isVisible = false;
		else {
			tickCount--;
		}
	}
	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
}
