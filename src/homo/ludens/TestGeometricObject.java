package homo.ludens;
import java.awt.Color;

/**
 * Kleine {@code main}-Methode, um {@link GeometricObject} per Hand zu
 * erproben: Konstruktor-Überladungen, {@code equals}, {@code moveTo}
 * und {@code contains}. Kein echtes Unit-Testing-Framework — aber
 * didaktisch ein wichtiger Einstieg in "Ich probiere meinen Code aus".
 */
public class TestGeometricObject {

	public static void main(String[] args) {
		GeometricObject o1 = new GeometricObject(17,4, new Vertex(42,23),new Color(23,56,34));
		GeometricObject o2 = new GeometricObject(17,4);
		GeometricObject o3 = new GeometricObject(17);
		GeometricObject o4 = new GeometricObject();

	    System.out.println(o1.equals(o2));
	    o2.moveTo(42,23);
	    System.out.println(o1.equals(o2));
	    System.out.println(o3.contains(new Vertex(10,3)));
	    System.out.println(o4);
	}

}
