package homo.ludens;

/**
 * Ein {@code Paintable} ist alles, was sich auf ein AWT-{@code Graphics}
 * zeichnen kann.
 *
 * <h2>Didaktische Konzepte</h2>
 * <ul>
 *   <li><b>Interface:</b> Ein Interface beschreibt <em>was</em> ein Objekt
 *       können muss, nicht <em>wie</em>. Jede Klasse, die
 *       {@code implements Paintable} schreibt, verpflichtet sich, die
 *       Methode {@link #paintTo(java.awt.Graphics)} bereitzustellen.</li>
 *   <li><b>Austauschbarkeit:</b> Ein {@link PaintablePanel} kann jeden
 *       Paintable zeichnen — egal ob Oval, Stern, Bild oder selbst wieder
 *       ein Panel mit mehreren Paintables. Das Panel kennt nur den
 *       Interface-Typ und nicht die konkrete Klasse.</li>
 * </ul>
 */
public interface Paintable {

	/**
	 * Zeichnet sich selbst in den gegebenen Grafik-Kontext.
	 *
	 * @param g Ziel-Graphics (üblicherweise aus {@code paintComponent})
	 */
	void paintTo(java.awt.Graphics g);

}
