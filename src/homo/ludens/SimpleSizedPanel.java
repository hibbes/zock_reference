package homo.ludens;
import homo.ludens.util.ShowInFrame;

/**
 * Minimal-Demo für {@link SizedPanel}: zeichnet einfach ein festes
 * Rechteck. Wird hauptsächlich für die {@code main}-Methode benutzt, um
 * zu zeigen, dass {@link SizedPanel#getPreferredSize()} und das eigene
 * {@code paintComponent} zusammenarbeiten.
 */
public class SimpleSizedPanel extends SizedPanel {
	public void paintComponent(java.awt.Graphics g){
		g.fillRect(30, 50, 45, 80);
	}

	public static void main(String[] args) {
		ShowInFrame.show(new SimpleSizedPanel());
	}

}
