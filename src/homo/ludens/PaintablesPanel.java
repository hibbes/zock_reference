package homo.ludens;
import homo.ludens.util.ShowInFrame;
import java.util.*;

/**
 * Ein Panel, das eine {@code List<Paintable>} zeichnet. Funktional
 * gleich wie {@link PaintableArrayPanel}, aber mit einer Liste statt
 * eines Arrays — schönes Vergleichsbeispiel für die Wahl des
 * Container-Typs.
 */
public class PaintablesPanel extends SizedPanel{
	List<Paintable> pas;

public PaintablesPanel(List<Paintable> pas){this.pas=pas;}

public void paintComponent(java.awt.Graphics g){
	for (Paintable pa:pas) pa.paintTo(g);
}
	public static void main(String[] args) {
		List<Paintable> ps = new ArrayList<Paintable>();
		ps.add(new PaintableOval(100,50,30,50));
		ps.add(new PaintableOval(100,50,130,150));

		ShowInFrame.show("Ovale",new PaintablesPanel(ps));
	}

}
