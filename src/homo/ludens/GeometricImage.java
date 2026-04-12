package homo.ludens;
import homo.ludens.util.ShowInFrame;
import javax.swing.*;

/**
 * Ein Bild, das sich wie ein {@link GeometricObject} verhält — also
 * eine Position, Breite und Höhe hat — und sich über {@link Paintable}
 * selbst zeichnen kann.
 *
 * <p>Didaktisch schön ist die Kombination aus <b>Vererbung</b>
 * ({@code extends GeometricObject}) und <b>Interface-Implementierung</b>
 * ({@code implements Paintable}). Breite und Höhe werden nicht vom
 * Benutzer übergeben, sondern aus dem geladenen Bild ausgelesen — dafür
 * ist die private {@link #init()}-Methode zuständig.</p>
 */
public class GeometricImage extends GeometricObject implements Paintable{

	ImageIcon icon;

	/**
	 * Lädt das Bild als Klassenpfad-Ressource.
	 *
	 * @param fileName Ressourcenname, z.&nbsp;B. {@code "test.png"}
	 *                 (muss im Classpath liegen)
	 */
	public GeometricImage(String fileName, double x, double y){
		super(new Vertex(x,y));
		icon=new ImageIcon(getClass().getClassLoader().getResource(fileName));
		init();
	}

	/** Variante mit bereits geladenem ImageIcon (wird z.&nbsp;B. zum Sharing verwendet). */
	public GeometricImage(ImageIcon icon, double x, double y){
		super(new Vertex(x,y));
		this.icon=icon;
		init();
	}

	/** Liest Breite/Höhe aus dem Icon und speichert sie in den Feldern der Oberklasse. */
	void init(){
		width= icon.getImage().getWidth(icon.getImageObserver());
		height=icon.getImage().getHeight(icon.getImageObserver());
	}

	/** Zeichnet das Icon an der aktuellen Position. */
	public void paintTo(java.awt.Graphics g){
		icon.paintIcon(null, g, (int)pos.x, (int)pos.y);
	}

	public static void main (String [] args){
		GeometricImage gi = new GeometricImage("test.png",10,10);
		System.out.println(gi.width);
		System.out.println(gi.height);
		ShowInFrame.show(new PaintablePanel(gi));
	}
}
