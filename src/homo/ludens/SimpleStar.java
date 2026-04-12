package homo.ludens;
import java.awt.Color;

/**
 * Ein einfacher "Stern" — eigentlich ein Polygon aus acht Eckpunkten, die
 * sich relativ zu {@code pos} ergeben. Die Punkte werden im Konstruktor
 * einmal ausgerechnet und in {@code xPoints}/{@code yPoints} gecached.
 *
 * <h2>Didaktische Konzepte und Stolperfallen</h2>
 * <ul>
 *   <li><b>Feld-Initialisierung vor dem Konstruktor:</b> Die Arrays
 *       {@code xPoints}/{@code yPoints} am Klassen-Anfang werden mit
 *       dem <em>Standard-Pos</em> aus {@link GeometricObject} (also
 *       {@code (0,0)}) initialisiert — zu diesem Zeitpunkt ist die
 *       echte Position noch gar nicht gesetzt. Der Konstruktor
 *       überschreibt die Arrays dann mit den richtigen Werten. Wer das
 *       nicht weiß, wundert sich leicht, warum "doppelte" Arrays im
 *       Code auftauchen.</li>
 *   <li><b>Achtung Bug:</b> Der Konstruktor ruft {@code super(...)}
 *       nicht mit der Position auf — er setzt nur die zwischen­gespeicherten
 *       Polygon-Koordinaten. Damit bleibt {@code this.pos} bei
 *       {@code (0,0)}, obwohl der Stern grafisch richtig gezeichnet
 *       wird. {@code contains(...)}, {@code moveTo(...)} &amp; Co.
 *       arbeiten also mit einer falschen Position. Für den reinen
 *       Zeichen-Zweck reicht es, für ein "echtes" Spielobjekt wäre
 *       das zu beheben.</li>
 * </ul>
 */
public class SimpleStar extends GeometricObject {

	// Create a polygon
    int[] xPoints = {(int)pos.x, (int)pos.x+20, (int)pos.x+30, (int)pos.x+40, (int)pos.x+60, (int)pos.x+40, (int)pos.x+30, (int)pos.x+20};
    int[] yPoints = {(int)pos.y, (int)pos.y-10, (int)pos.y-30, (int)pos.y-10, (int)pos.y, (int)pos.y+10, (int)pos.y+30, (int)pos.y+10};
    int nPoints = xPoints.length;




	public SimpleStar(Vertex pos, Color color){
		 int[] xPoints = {(int)pos.x, (int)pos.x+20, (int)pos.x+30, (int)pos.x+40, (int)pos.x+60, (int)pos.x+40, (int)pos.x+30, (int)pos.x+20};
		 int[] yPoints = {(int)pos.y, (int)pos.y-10, (int)pos.y-30, (int)pos.y-10, (int)pos.y, (int)pos.y+10, (int)pos.y+30, (int)pos.y+10};
		 int nPoints = xPoints.length;

		this.xPoints=xPoints;
		this.yPoints=yPoints;
		this.nPoints=nPoints;
		this.color=color;

	}



/*
 *  Das könnte kompliziert werden!
	public @Override String toString(){
		return "SimpleOval("+super.toString()+")";
	}


 *
 * 	public @Override boolean equals(Object that){


		return (that instanceof SimpleOval) && super.equals(that);
	}*/
}
