package homo.ludens;

/**
 * Ein Panel, das mehrere {@link Paintable}-Objekte aus einem Array
 * zeichnet. Zeigt das <em>Composite</em>-Prinzip: das Panel ist selbst
 * ein {@code JPanel}, <em>enthält</em> aber beliebig viele Paintables
 * und delegiert das Zeichnen an sie.
 *
 * <p>Vergleiche mit {@link PaintablesPanel} (mit {@code List}) und
 * {@link PaintablePanel} (genau ein Paintable).</p>
 */
public class PaintableArrayPanel extends SizedPanel{

	Paintable[] ps;

	public PaintableArrayPanel(Paintable[] pa){ps=pa;}

	public void paintComponent(java.awt.Graphics g){
		for(Paintable p:ps) p.paintTo(g);
	}

}
