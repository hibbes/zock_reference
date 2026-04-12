package homo.ludens;
import javax.swing.*;
import java.awt.Dimension;
import homo.ludens.util.ShowInFrame;

/**
 * {@link JPanel} mit einer festen Wunschgröße. Dient als Basis für alle
 * Zeichen-Panels im Projekt.
 *
 * <h2>Didaktische Konzepte</h2>
 * <ul>
 *   <li><b>Überschreiben einer Methode der Oberklasse:</b>
 *       {@link #getPreferredSize()} wird überschrieben, damit Swing
 *       beim {@code pack()} unsere Größe nutzt — sonst bekäme man ein
 *       winziges Fenster.</li>
 *   <li><b>Zwei Konstruktoren:</b> einmal ohne Argumente (Default 400×400),
 *       einmal mit Breite/Höhe. Klassisches Überladungs-Beispiel.</li>
 * </ul>
 */
public class SizedPanel extends JPanel {

	int preferredWidth=400;
	int preferredHeight=400;


	public static void main(String[] args) {
		ShowInFrame.show(new SizedPanel());
	}

	public SizedPanel(int w, int h){
		preferredWidth=w;
		preferredHeight=h;
	}

	public SizedPanel(){}

	@Override public Dimension getPreferredSize(){
		return new Dimension(preferredWidth,preferredHeight);
	}
}
