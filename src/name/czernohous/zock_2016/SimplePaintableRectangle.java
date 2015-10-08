package name.czernohous.zock_2016;
import java.awt.Color;
import java.awt.Graphics;
public class SimplePaintableRectangle extends SimpleRectangle implements Paintable{

			public SimplePaintableRectangle(double width, double height, double x, double y, Color color){
			super(width,height,new Vertex(x,y),color);
		}
		
		public void paintTo(java.awt.Graphics g){ 
			g.setColor(color);
			g.fillRect((int)pos.x, (int)pos.y, (int)width, (int)height);
		}
	}
	

