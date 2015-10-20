package name.czernohous.zock_2016;
import java.awt.Color;
public class PaintableOval extends SimpleOval implements Paintable {

	public PaintableOval(double width, double height, double x, double y, Color color){
		super(width,height,x,y,color);
	}
	
	public PaintableOval(double width, double height, double x, double y){
		this(width,height,x,y,Color.black);
	}
	
	
	public void paintTo(java.awt.Graphics g){
		g.setColor(color);
		g.fillOval((int)pos.x, (int)pos.y, (int)width, (int)height);
	}
}
