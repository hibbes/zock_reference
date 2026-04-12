package homo.ludens;

import homo.ludens.util.ShowInFrame;
import javax.swing.JPanel;

/**
 * Verbindet {@link MyImage} mit dem {@link Paintable}-Interface. Die
 * Klasse erbt zwar von {@code JPanel} — genutzt wird davon hier aber
 * nur der {@code ImageObserver}-Charakter (für {@code drawImage}).
 *
 * <p>Didaktisch interessant: Obwohl {@code PaintableImage} ein
 * {@code JPanel} ist, wird es hier <em>nicht</em> als eigenständiges
 * Panel verwendet, sondern lediglich über {@link Paintable} in ein
 * anderes Panel hineingezeichnet.</p>
 */
	public class PaintableImage extends JPanel implements Paintable{
		MyImage mi;

		public PaintableImage(MyImage mi){this.mi=mi;}
		public PaintableImage(String name){this.mi=new MyImage(name);}

		/** Zeichnet das gekapselte Bild an Position (0,0). */
		public void paintTo(java.awt.Graphics g){
			g.drawImage(mi.get(),0,0,this);
		}

		public static void main(String[]args){
			PaintableImage pi= new PaintableImage("test.png"); // Direkt ins bin-Verzeichnis
			System.out.println(pi.mi.get().getHeight(pi));
			ShowInFrame.show(new PaintablePanel(pi));
		}

}
