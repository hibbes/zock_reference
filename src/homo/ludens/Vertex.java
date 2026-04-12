package homo.ludens;

/**
 * Ein einfacher 2D-Ortsvektor (bzw. Punkt) mit den Komponenten {@code x} und
 * {@code y}.
 *
 * <h2>Didaktische Konzepte</h2>
 * <ul>
 *   <li><b>Datenkapselung light:</b> Die Felder sind {@code public} — das ist
 *       bewusst vereinfacht; normalerweise würden wir sie {@code private}
 *       machen und ausschließlich über Getter/Setter zugreifen. Zum Lernen
 *       spart es Tippen.</li>
 *   <li><b>Immutable vs. mutable:</b> Viele Operationen gibt es in zwei
 *       Varianten: {@link #skalarMult(double)} liefert einen <em>neuen</em>
 *       Vektor (immutable style), {@link #skalarMultMod(double)} verändert
 *       den aktuellen Vektor direkt (mutable style, daher das "Mod" für
 *       "modify"). Das ist ein wichtiger Unterschied, der auch in echten
 *       Bibliotheken auftaucht — z.&nbsp;B.&nbsp;liefert {@code String.trim()}
 *       einen neuen String, während {@code StringBuilder.append()} das
 *       Objekt selbst verändert.</li>
 *   <li><b>Überladung (overloading):</b> Die Methode {@link #add(double)} und
 *       {@link #add(Vertex)} haben denselben Namen, aber unterschiedliche
 *       Parameter-Typen. Java wählt automatisch die passende Variante.</li>
 *   <li><b>Gleichheit:</b> {@link #equals(Object)} wird überschrieben, damit
 *       zwei Vertex-Objekte mit gleichen Koordinaten als "gleich" gelten —
 *       nicht nur dasselbe Objekt im Speicher.</li>
 * </ul>
 */
public class Vertex {

	/** X-Koordinate (öffentlich für einfachen Zugriff im Unterricht). */
	public double x;
	/** Y-Koordinate. */
	public double y;

	/**
	 * Erzeugt einen Vektor mit den gegebenen Koordinaten.
	 *
	 * @param x X-Komponente
	 * @param y Y-Komponente
	 */
	public Vertex(double x, double y){
		this.x=x;
		this.y=y;


	}


	/** Liefert eine menschenlesbare Form wie {@code (3.0, 4.0)}. */
	@Override public String toString() {
		return "("+x+", "+y+")";
		}

	/**
	 * Länge (Betrag) des Vektors: {@code sqrt(x² + y²)}.
	 * Entspricht dem Satz des Pythagoras.
	 */
	public double length(){
		return Math.sqrt(x*x+y*y);
		}


	/**
	 * Skalarmultiplikation — liefert einen <em>neuen</em> Vektor, ohne
	 * den aktuellen zu verändern (immutable style).
	 *
	 * @param s Skalar
	 * @return neuer Vektor {@code (x·s, y·s)}
	 */
	public Vertex skalarMult(double s){
		return new Vertex(x*s,y*s);
	    }

	/**
	 * Skalarmultiplikation <em>in-place</em>: verändert diesen Vektor
	 * direkt. Nichts wird zurückgegeben. Vergleiche mit
	 * {@link #skalarMult(double)}.
	 */
	public void skalarMultMod(double s){
		x=x*s;
		y=y*s;
		}

	/**
	 * Addiert denselben Skalar auf beide Komponenten und liefert einen
	 * neuen Vektor. Nützlich z.&nbsp;B. für "Verschiebe alles um 5".
	 */
	public Vertex add(double s){
		return new Vertex(x+s,y+s);
	    }

	/**
	 * Vektoraddition (komponentenweise), liefert einen neuen Vektor.
	 * Beispiel für <b>Methoden-Überladung</b>: gleicher Name wie
	 * {@link #add(double)}, anderer Parametertyp.
	 */
	public Vertex add(Vertex v){
		return new Vertex(x+v.x,y+v.y);
	    }


	/**
	 * Verschiebt diesen Vektor in-place um {@code (x, y)}.
	 */
	public void addMod(double x, double y){
		this.x=this.x+x;
		this.y=this.y+y;
	}

	/**
	 * Verschiebt in-place um denselben Wert in beiden Richtungen.
	 * Ruft über {@code this} die andere Variante auf — schönes Beispiel
	 * dafür, dass man Duplikation durch Delegation vermeiden kann.
	 */
	public void addMod(double s){
		addMod(s,s);
	}

	/** Verschiebt in-place um einen anderen Vektor. */
	public void addMod(Vertex v){
		addMod(v.x,v.y);
	}

	public double getX(){return x;}

	public double getY(){return y;}

	public void setX(double x){this.x=x;}

	public void setY(double y){this.y=y;}

	/**
	 * Zwei Vertex-Objekte sind gleich, wenn beide Koordinaten exakt
	 * übereinstimmen.
	 *
	 * <p>Didaktisch wichtig: der Parameter ist vom Typ {@code Object},
	 * weil wir {@code Object.equals} überschreiben. Erst mit
	 * {@code instanceof} prüfen wir den Typ, dann casten wir. Ohne
	 * diesen Pattern würden wir {@code equals} nur überladen statt
	 * überschreiben und Java würde in vielen Fällen die falsche Methode
	 * wählen.</p>
	 *
	 * <p>Hinweis: {@code ==} auf {@code double} ist wegen Rundungsfehlern
	 * heikel. Für ein Lehrprojekt ist das ok — in echter Produktion
	 * würde man eine Epsilon-Toleranz verwenden.</p>
	 */
	public boolean equals(Object thatObject){
		if (thatObject instanceof Vertex){
			Vertex that =(Vertex)thatObject;

			return this.x==that.x && this.y==that.y;
		}
		return false;
	}


	/**
	 * Euklidischer Abstand zwischen diesem und einem anderen Vertex.
	 * Klassische Anwendung des Satzes von Pythagoras.
	 */
	public double distance(Vertex v2){
		double xx=v2.x-this.x;
		double yy=v2.y-this.y;

		return Math.sqrt(xx*xx+yy*yy);
	}

	/**
	 * Normiert diesen Vektor auf Länge 1 (in-place).
	 *
	 * <p>Achtung: Ist die Länge 0, dann wird durch 0 geteilt und die
	 * Koordinaten werden zu {@code NaN}. In einer robusten Variante
	 * sollte man diesen Fall abfangen. Für den Unterricht ist das
	 * bewusst so gelassen, um den Fall im Debugger selbst zu
	 * entdecken.</p>
	 */
	public void normalize(){
		double factor =  this.length();
		x=x/factor;
		y=y/factor;

	}


}
