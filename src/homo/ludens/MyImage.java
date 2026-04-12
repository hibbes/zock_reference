package homo.ludens;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * Ein kleiner, trägheits-geladener ("lazy") Bild-Wrapper: Das eigentliche
 * {@link Image} wird erst beim ersten {@link #get()}-Aufruf geladen und
 * danach gecached.
 *
 * <h2>Didaktische Konzepte</h2>
 * <ul>
 *   <li><b>Kapselung:</b> {@code name} und {@code img} sind
 *       {@code private} — der Rest der Welt sieht nur {@link #get()}.</li>
 *   <li><b>Lazy Initialization:</b> Der Check {@code if (img == null)}
 *       sorgt dafür, dass das teure Laden nur einmal passiert.</li>
 * </ul>
 */
public class MyImage {

	private String name;
	private Image img=null;

	public MyImage(String name) {this.name=name;}

	/** Liefert das Bild, lädt es beim ersten Aufruf nach. */
	public Image get(){
		if(img==null)
			img=Toolkit.getDefaultToolkit().createImage(getClass().getClassLoader().getResource(name));
		return img;
	}
}
