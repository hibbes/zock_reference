package homo.ludens;

/**
 * Ein {@code Movable} ist ein Objekt, das sich bewegen und drehen kann.
 *
 * <p>Didaktisch: zeigt dieselbe Idee wie {@link Paintable} — ein Interface
 * fordert Methoden, die Implementierungen füllen sie mit Leben. Ein
 * {@link GameObject} kombiniert beide Interfaces per Mehrfach-Vererbung
 * von Interfaces ({@code extends Movable, Paintable}).</p>
 *
 * <p>Dieses Interface ist <em>package-private</em> — es ist absichtlich nur
 * innerhalb von {@code homo.ludens} sichtbar.</p>
 */
interface Movable {
	/** Bewegt das Objekt einen Schritt weiter (z.&nbsp;B. pro Spiel-Tick). */
	void move();
	/** Ändert die Bewegungsrichtung (konkrete Semantik pro Klasse). */
	void turn();
}
