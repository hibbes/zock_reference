package homo.ludens;
import java.util.*;

/**
 * Ein Panel, das eine Liste von {@link GameObject}s verwaltet, sie bei
 * jedem Tick bewegt und neu zeichnet.
 *
 * <p>Didaktisch zeigt das die typische <em>Game-Loop</em>-Struktur in
 * Miniatur: {@code move()} aktualisiert den Zustand, {@code repaint()}
 * fordert ein neues Zeichnen an. Der eigentliche Tick-Timer wird in
 * einer Unterklasse oder Aufruferin ergänzt.</p>
 */
public class MovablePanel extends SizedPanel {


 /** Alle Spielobjekte in Zeichen- und Bewegungsreihenfolge. */
 List<GameObject> gos = new ArrayList<GameObject>();

public void paintComponent(java.awt.Graphics g) {
	super.paintComponent(g);
	for (GameObject go:gos) go.paintTo(g);
}

/** Bewegt jedes Objekt einen Schritt weiter. */
public void move() {for (GameObject go:gos) go.move();}

/** Ein einzelner Spiel-Tick: bewegen + neu zeichnen. */
public void doOnTick() {
		move () ;
		repaint () ;

		}
}
