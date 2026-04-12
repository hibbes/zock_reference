package homo.ludens;

/**
 * Alles, was in einem Spiel "lebt" — d.&nbsp;h. sich bewegen und zeichnen
 * lässt und geometrische Eigenschaften hat.
 *
 * <h2>Didaktische Konzepte</h2>
 * <ul>
 *   <li><b>Mehrere Interfaces erben:</b> Ein Interface darf von
 *       <em>mehreren</em> anderen erben — hier sowohl von {@link Movable}
 *       als auch von {@link Paintable}. Damit muss ein GameObject
 *       insgesamt {@code move()}, {@code turn()} und {@code paintTo()}
 *       bereitstellen.</li>
 *   <li><b>Kollisions- und Vergleichslogik:</b> Die Methoden
 *       {@link #isLeftOf(GameObject)}, {@link #isAbove(GameObject)} und
 *       {@link #touches(GameObject)} beschreiben die räumliche Beziehung
 *       zu einem anderen Game-Objekt — die Grundlage jeder einfachen
 *       Kollisions-Erkennung.</li>
 *   <li><b>Interface statt konkrete Klasse:</b> Felder wie "Liste aller
 *       Spielobjekte" können als {@code List<GameObject>} typisiert
 *       werden. Dadurch kann man Bälle, Gegner, Bilder usw. in derselben
 *       Liste halten.</li>
 * </ul>
 */
public interface GameObject extends Movable, Paintable{
	double getWidth();
	double getHeight();
	Vertex getPos();
	/** Aktueller Geschwindigkeitsvektor (Bewegung pro Tick). */
	Vertex getDeltaPos();
	/** Setzt den Geschwindigkeitsvektor. */
	void setDeltaPos(Vertex v);
	boolean isLargerThan(GameObject that);
	boolean isLeftOf(GameObject that);
	boolean isAbove(GameObject that);
	/** {@code true}, wenn sich die Bounding-Boxes überlappen. */
	boolean touches(GameObject that);

}
