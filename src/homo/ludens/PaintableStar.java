package homo.ludens;
import java.awt.Color;

/**
 * Ein Stern, der sich selbst zeichnen kann. Erbt die vorbereiteten
 * Polygon-Punkt-Arrays von {@link SimpleStar} und liefert nur noch
 * die {@link Paintable#paintTo(java.awt.Graphics) paintTo}-Methode nach.
 */
public class PaintableStar extends SimpleStar implements Paintable{

		public PaintableStar(Vertex pos, Color color){
			super(pos, color);
		}

		public void paintTo(java.awt.Graphics g){
			g.setColor(color);
			g.drawPolygon(xPoints, yPoints, nPoints);
		}
	}


