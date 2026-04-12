package homo.ludens;
import java.awt.Color;

/**
 * Basisklasse für alle geometrischen Formen im Projekt (Rechtecke, Ovale,
 * Sterne, Bilder, Dreiecke &hellip;). Hält die gemeinsamen Eigenschaften
 * <em>Position</em>, <em>Breite</em>, <em>Höhe</em> und <em>Farbe</em>.
 *
 * <h2>Didaktische Konzepte</h2>
 * <ul>
 *   <li><b>Vererbung:</b> Jede konkrete Form ({@link SimpleRectangle},
 *       {@link SimpleOval}, &hellip;) <em>erbt</em> von dieser Klasse und
 *       erweitert sie um ihr spezifisches Verhalten (z.&nbsp;B. eine eigene
 *       {@code area()}-Berechnung).</li>
 *   <li><b>Konstruktor-Verkettung mit {@code this(...)}:</b> Statt jeden
 *       Konstruktor einzeln mit Logik zu füllen, ruft ein kürzerer
 *       Konstruktor einfach einen ausführlicheren auf. So gibt es nur
 *       <em>eine</em> Stelle mit echter Initialisierungs-Logik; alle
 *       anderen reichen mit passenden Default-Werten weiter. Achte auf
 *       die Kaskade: {@code GeometricObject() → GeometricObject(10)
 *       → GeometricObject(10,10) → GeometricObject(10,10,new Vertex(0,0),
 *       new Color(0,0,0))}.</li>
 *   <li><b>Polymorphismus:</b> Da {@link #area()} überschrieben werden
 *       kann, liefert z.&nbsp;B. {@code isLargerThan} bei Ovalen und
 *       Rechtecken automatisch das richtige Ergebnis — ohne die Methode
 *       zu ändern.</li>
 *   <li><b>Defensive Normalisierung:</b> Negative Breite oder Höhe werden
 *       im Konstruktor in positive umgerechnet und die Position passend
 *       verschoben, damit der Bounding-Box-Ansatz in {@link #contains}
 *       immer stimmt.</li>
 * </ul>
 */
public class GeometricObject {

	/** Linke obere Ecke der Bounding-Box. */
	public Vertex pos;
	/** Höhe in Pixeln. Nach dem Konstruktor immer &ge; 0. */
	public double height;
	/** Breite in Pixeln. Nach dem Konstruktor immer &ge; 0. */
	public double width;
	/** Füll- bzw. Linienfarbe. */
	public Color color;


	/**
	 * Haupt-Konstruktor — alle anderen rufen letztlich diesen hier auf.
	 *
	 * <p>Werden negative Werte für {@code width} oder {@code height}
	 * übergeben, dreht der Konstruktor sie um und verschiebt die Position
	 * so, dass dasselbe Rechteck entsteht (bewährter Trick, damit
	 * {@link #contains(Vertex)} immer funktioniert).</p>
	 */
	public GeometricObject(double width, double height, Vertex pos, Color color){
		this.pos=pos;
		this.width=width;
		this.height=height;
		this.color=color;

		if(this.width<0){
			this.width = -this.width;
			pos.x = pos.x -this.width;
			}
		if(this.height<0){
			this.height = -this.height;
			pos.y = pos.y -this.height;
			}

	}

	/** Bequemlichkeits-Konstruktor ohne explizite Position — setzt (0,0). */
	public GeometricObject(double width, double height, Color color){
		this(width, height, new Vertex(0,0),color);
	}

	/** Bequemlichkeits-Konstruktor: Position (0,0), Farbe schwarz. */
	public GeometricObject(double width, double height){
		this(width, height, new Vertex(0,0), new Color(0,0,0));
	}

	/** Quadratisches Objekt der Seitenlänge {@code width}. */
	public GeometricObject(double width){this(width,width);}

	/** Standard-Objekt 10×10 an (0,0) in Schwarz. */
	public GeometricObject(){this(10);}

	/** Objekt der Größe 0×0 an beliebiger Position (z.&nbsp;B. für Bilder, die ihre Größe erst später kennen). */
	public GeometricObject(Vertex pos){this(0,0,pos,new Color(0,0,0));}

    public double getWidth(){return width;}

    public double getHeight(){return height;}

    public Vertex getPos(){return pos;}

    public String toString(){
    	return "width="+width+", height="+height+", pos="+pos+", color="+color;
    }
    /** Umfang der Bounding-Box. Wird in Unterklassen z.&nbsp;T. überschrieben. */
    public double circumference(){return 2*(width+height);}

    /** Flächeninhalt der Bounding-Box. Wird in {@link SimpleOval},
     *  {@link EquilateralTriangle} usw. mit passender Formel überschrieben. */
    public double area(){return width*height;}

    /**
     * Prüft, ob der gegebene Punkt <em>innerhalb</em> der Bounding-Box
     * liegt (Ränder zählen mit).
     *
     * <p>Didaktisch schön: Die Bedingung ist eine einzige boolesche
     * Rückgabe aus vier Teil-Vergleichen mit {@code &&}. So kann man
     * oft komplett auf {@code if/else} verzichten.</p>
     */
    public boolean contains(Vertex v){
    	return v.x >=pos.x && v.x <=pos.x+width // ist x drin?
    	&& v.y >=pos.y && v.y <=pos.y+height;  // ist y drin?
    }

    /**
     * {@code true}, wenn diese Form einen größeren Flächeninhalt hat als
     * die andere. Nutzt {@link #area()} — dank Polymorphismus ohne
     * Änderung auch für Ovale usw. passend.
     */
    public boolean isLargerThan(GeometricObject that){
    	return this.area()>that.area();
    }

    /** Setzt die Position auf einen neuen Vertex (Referenz). */
    public void moveTo(Vertex pos){this.pos=pos;}

    /** Überladung: positioniert per Koordinaten. Erzeugt intern einen Vertex. */
    public void moveTo(double x, double y){
    	moveTo(new Vertex(x,y));
    }

    /** Relative Verschiebung: {@code pos = pos + v}. */
    public void move(Vertex v){moveTo(pos.add(v));}


	/**
	 * Zwei GeometricObjects sind gleich, wenn Breite, Höhe und Position
	 * übereinstimmen. Farbe wird bewusst ignoriert.
	 *
	 * <p>Didaktisch: gleiches Muster wie in {@link Vertex#equals(Object)} —
	 * {@code instanceof}-Check, dann Cast, dann Vergleich. Die
	 * Unterklassen ({@link SimpleRectangle}, {@link SimpleOval}, &hellip;)
	 * erweitern dieses Muster um einen zusätzlichen Typ-Check.</p>
	 */
	public boolean equals(Object thatObject){
		if (thatObject instanceof GeometricObject){
			GeometricObject that =(GeometricObject)thatObject;

			return that.width==this.width && this.height==that.height
					&& this.pos.equals(that.pos);
		}
		return false;
	 }
}

