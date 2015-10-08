package name.czernohous.zock_2016;
import java.awt.Color;

public class PaintableStar extends SimpleStar implements Paintable{
	
		public PaintableStar(int[] xPoints, int[] yPoints, int nPoints, Color color){
			super(xPoints, yPoints, nPoints, color);
		}
		
		public void paintTo(java.awt.Graphics g){
			g.setColor(color);
			g.drawPolygon(xPoints, yPoints, nPoints);
		}
	}


