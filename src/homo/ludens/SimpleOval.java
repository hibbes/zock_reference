
package homo.ludens;
import java.awt.Color;

/**
 * Ein Oval als {@link GeometricObject}. Überschreibt vor allem
 * {@link #area()} mit der korrekten Ellipsen-Formel
 * <code>&pi;·w·h/4</code> — Beispiel dafür, wie Polymorphismus den
 * Unterschied zwischen Bounding-Box-Fläche und echter Fläche
 * transportiert.
 */
public class SimpleOval extends GeometricObject {

	public SimpleOval(double w, double h, Vertex pos, Color color){
		super(w,h,pos,color);
	}

	public SimpleOval(double w, double h, double x, double y, Color color){
		super(w,h,new Vertex(x,y),color);
	}

	public SimpleOval(double w, double h, double x, double y){
		super(w,h,new Vertex(x,y),new Color(0,0,0));
	}
	@Override public double area(){return Math.PI*width*height/4;}

	public @Override String toString(){
		return "SimpleOval("+super.toString()+")";
	}

	public @Override boolean equals(Object that){
		return (that instanceof SimpleOval) && super.equals(that);
	}
}
