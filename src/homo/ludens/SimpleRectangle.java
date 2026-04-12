package homo.ludens;
import java.awt.Color;

/**
 * Einfaches Rechteck. Die Fläche wird <em>nicht</em> überschrieben —
 * {@code width · height} aus der Oberklasse stimmt bereits.
 *
 * <p>Didaktisch schön zum Vergleich mit {@link SimpleOval} oder
 * {@link EquilateralTriangle}: nur dort, wo die Formel anders ist, muss
 * man {@code area()} überhaupt überschreiben.</p>
 */
public class SimpleRectangle extends GeometricObject {




	public SimpleRectangle(double w, double h, Vertex pos, Color color){
		super(w,h,pos,color);
	}

	public SimpleRectangle(double w, double h){
		super(w,h,new Vertex(0,0), new Color(0,0,0));
	}

	public @Override String toString(){
		return "SimpleRectangle("+super.toString()+")";
	}

	public @Override boolean equals(Object that){
		return (that instanceof SimpleRectangle) && super.equals(that);
	}
}
