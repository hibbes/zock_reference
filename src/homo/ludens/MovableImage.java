package homo.ludens;

import javax.swing.ImageIcon;

/**
 * Ein {@link GeometricImage}, das zusätzlich das {@link GameObject}-Interface
 * erfüllt — also eigene Geschwindigkeit ({@code deltaPos}), Kollisions-
 * und Vergleichsmethoden mitbringt.
 *
 * <h2>Didaktische Konzepte</h2>
 * <ul>
 *   <li><b>Erben <em>und</em> Implementieren:</b> Die Klasse erbt von
 *       {@code GeometricImage} (für {@code paintTo} und die Bounding-Box)
 *       und verspricht gleichzeitig, {@code GameObject} vollständig zu
 *       erfüllen.</li>
 *   <li><b>Geschwindigkeit als Vektor:</b> {@code deltaPos} beschreibt,
 *       wie weit sich das Bild pro {@code move()}-Aufruf bewegt — ein
 *       klassisches 2D-Spiel-Pattern.</li>
 * </ul>
 *
 * <p><b>Hinweis zu bekannten Bugs — siehe Kommentare an den einzelnen
 * Methoden {@link #move()}, {@link #isLeftOf(GameObject)} und
 * {@link #touches(GameObject)}. Die Originallogik ist dort erhalten,
 * die Kommentare zeigen den korrekten Ansatz.</b></p>
 */
class MovableImage extends GeometricImage implements GameObject{
 Vertex deltaPos = new Vertex(0,0);

 public Vertex getDeltaPos(){return deltaPos;}

 public void setDeltaPos(Vertex v){deltaPos=v;}

	public MovableImage(String name, double x, double y){
	super(name,x,y);
	}
	public MovableImage(String name, double x, double y, double dX, double dY){
		super(name,x,y);
		deltaPos= new Vertex(dX,dY);}

	public MovableImage(ImageIcon icon, double x, double y, double dX, double dY){
		super(icon,x,y);
		deltaPos=new Vertex(dX, dY);
	}

	/**
	 * Bewegt das Objekt um {@code deltaPos} weiter.
	 *
	 * <p><b>Anmerkung:</b> Die ursprüngliche Implementierung rief
	 * {@code deltaPos.skalarMultMod(-1)} auf — das kehrt aber nur die
	 * Geschwindigkeit um und bewegt gar nichts. Didaktisch gesehen ist
	 * das ein wichtiger Fehler, den man im Unterricht gut besprechen
	 * kann: "Was passiert, wenn {@code move} gar keine Bewegung
	 * enthält?". Die korrekte Variante wäre
	 * {@code pos.addMod(deltaPos);}.</p>
	 */
	public void move(){pos.addMod(deltaPos);}

	/**
	 * Kehrt die Bewegungsrichtung um. Klassischer "Abpraller"-Effekt.
	 */
	public void turn(){deltaPos.skalarMultMod(-1);}

	/**
	 * <b>Bug-Fix:</b> früher wurden hier versehentlich die
	 * y-Koordinaten verglichen (Copy-Paste aus {@link #isAbove}).
	 * Jetzt richtig: "links-von" prüft die rechte Kante von
	 * {@code this} gegen die linke Kante von {@code that}.
	 */
	public boolean isLeftOf(GameObject that){
		return this.getPos().x+this.getWidth()<that.getPos().x;
	}

	/** {@code this} liegt komplett <em>über</em> {@code that}. */
	public boolean isAbove(GameObject that){
		return this.getPos().y+this.getHeight()<that.getPos().y;
	}

	/**
	 * Zwei Objekte "berühren" sich (überlappen), wenn keines links vom
	 * oder über dem anderen liegt.
	 *
	 * <p><b>Bug-Fix:</b> Die ursprüngliche Variante rief
	 * {@code this.isLeftOf(this)} bzw. {@code this.isAbove(this)} auf —
	 * also den Vergleich mit sich selbst, was keinen Sinn ergibt. Jetzt
	 * werden beide Richtungen sauber gegen {@code that} geprüft.</p>
	 */
	public boolean touches(GameObject that){
		if (this.isLeftOf(that)){ return false;}
		if (that.isLeftOf(this)){ return false;}
		if (this.isAbove(that)){ return false;}
		if (that.isAbove(this)){ return false;}
		return true;
	}

	public boolean isLargerThan(GameObject that){
		return getWidth()*getHeight()>that.getWidth()*that.getHeight();
	}
}
