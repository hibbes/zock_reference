package homo.ludens;
import java.awt.Color;

/**
 * Ein gefülltes Oval, das sich selbst zeichnen kann. Erbt Geometrie und
 * Flächenformel von {@link SimpleOval} und liefert die
 * {@link Paintable#paintTo(java.awt.Graphics) paintTo}-Methode nach.
 */
public class PaintableOval extends SimpleOval implements Paintable {

	public PaintableOval(double width, double height, double x, double y, Color color){
		super(width,height,x,y,color);
	}

	/** Bequemlichkeit: Standardfarbe Schwarz. */
	public PaintableOval(double width, double height, double x, double y){
		this(width,height,x,y,Color.black);
	}


	public void paintTo(java.awt.Graphics g){
		g.setColor(color);
		g.fillOval((int)pos.x, (int)pos.y, (int)width, (int)height);
	}
}
