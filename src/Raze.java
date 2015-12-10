import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Raze implements IRenderable{
	protected int distance;
	//private int value;
	protected boolean isVisible;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	protected int tickCount;
	protected int x;
	public Raze(int distance,int direction){
		this.distance = distance;
		x = direction*distance + GameLogic.getPlayer().getX();
		tickCount = 0;
		isVisible = true;
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		BufferedImage image = ResourceUtility.getRaze(tickCount/2);
		g2.drawImage(image,null, x-50, 230);
	}
	public void update(){
		if(tickCount == 5) isVisible = false;
		else {
			tickCount++;
		}
	}
	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
}
