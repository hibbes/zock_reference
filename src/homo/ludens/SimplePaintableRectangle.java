package homo.ludens;
import java.awt.Color;

/**
 * Rechteck, das sich selbst zeichnen kann. Minimalbeispiel für
 * "Vererben + Interface implementieren": Erbt Geometrie von
 * {@link SimpleRectangle} und liefert {@code paintTo} für
 * {@link Paintable}.
 */
public class SimplePaintableRectangle extends SimpleRectangle implements Paintable{

			public SimplePaintableRectangle(double width, double height, double x, double y, Color color){
			super(width,height,new Vertex(x,y),color);
		}

		public void paintTo(java.awt.Graphics g){
			g.setColor(color);
			g.fillRect((int)pos.x, (int)pos.y, (int)width, (int)height);
		}
	}


