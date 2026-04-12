package homo.ludens;
import javax.swing.*;

/**
 * Erstes, minimalistisches Zeichen-Panel: zeigt, wie man
 * {@link JPanel#paintComponent(java.awt.Graphics)} überschreibt, um
 * eigene Formen zu zeichnen.
 *
 * <p>Didaktisch ein schöner Einstieg, bevor wir Interfaces wie
 * {@link Paintable} einführen — hier ist die Form direkt im Panel
 * "einbetoniert".</p>
 */
public class FirstPanel extends JPanel {

	    int[] xPoints = {40, 60, 70, 80, 100, 80, 70, 60};
	    int[] yPoints = {440, 430, 410, 430, 450, 470, 450, 460};
	    int nPoints = xPoints.length;

	/** Zeichnet ein Polygon aus den Festwerten oben. */
	@Override public void paintComponent(java.awt.Graphics g){
//		g.fillRect(30,50,45,80);
//		g.fillOval(60, 30, 80, 50);
		g.drawPolygon(xPoints, yPoints, nPoints);
	}

	public static void main(String []args){
		JFrame f=new JFrame();
		f.add(new FirstPanel());
		f.pack();
		f.setVisible(true);
	}
}
