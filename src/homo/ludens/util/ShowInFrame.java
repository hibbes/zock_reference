package homo.ludens.util;
import javax.swing.*;

/**
 * Winzige Hilfsklasse, die ein beliebiges {@link JComponent} in einem
 * {@link JFrame} anzeigt. Zwei Überladungen — mit und ohne Titel.
 *
 * <p>Didaktisch: zeigt, wie man wiederkehrenden GUI-Boilerplate
 * ({@code new JFrame, add, pack, setVisible}) in eine einzige
 * statische Methode auslagert.</p>
 */
public class ShowInFrame {

	/** Öffnet ein Fenster mit dem gegebenen Titel, das nur {@code c} enthält. */
	public static void show(String title,JComponent c) {
		JFrame f=new JFrame(title);
		f.add(c);
		f.pack();
		f.setVisible(true);
	}
		/** Variante ohne Titel. */
		public static void show(JComponent c){show("",c);}

}


