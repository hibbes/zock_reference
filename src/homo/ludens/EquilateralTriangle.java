package homo.ludens;
import java.awt.Color;

/**
 * Ein gleichseitiges Dreieck als {@link GeometricObject}. Zeigt, wie man
 * eine Unterklasse anlegt und dabei einzelne Methoden überschreibt.
 *
 * <p>Didaktisch wichtig ist hier vor allem der {@code @Override}-Marker
 * bei {@link #area()}: Die Basisklasse liefert die Fläche der
 * Bounding-Box zurück, das Dreieck berechnet seine Fläche jedoch
 * anders.</p>
 */
public class EquilateralTriangle extends GeometricObject{

	public EquilateralTriangle(double w, double h, Vertex pos, Color color){
		super(w,h,pos,color);
	}

	public EquilateralTriangle(double w, double h, double x, double y){
		super(w,h,new Vertex(x,y),new Color(0,0,0));
	}

	/**
	 * Fläche eines Dreiecks: {@code (Grundseite · Höhe) / 2}.
	 *
	 * <p><b>Bug-Fix:</b> Hier stand vorher {@code (width/height)/2}, was
	 * mathematisch unsinnig war und z.&nbsp;B. bei einem 10×10-Dreieck
	 * {@code 0.5} statt {@code 50} geliefert hat.</p>
	 */
	@Override public double area(){return (width*height)/2;}

	public @Override String toString(){
		return "EquilateralTriangle("+super.toString()+")";
	}

	public @Override boolean equals(Object that){
		return (that instanceof EquilateralTriangle) && super.equals(that);
	}
}

