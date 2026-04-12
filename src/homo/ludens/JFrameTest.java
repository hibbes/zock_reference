package homo.ludens;
import javax.swing.JFrame;

/**
 * Das absolute Minimalbeispiel für Swing: ein leeres Fenster mit Titel.
 * Dient vor allem als "compiliert meine Umgebung überhaupt?"-Test.
 */
public class JFrameTest {
   public static void main(String []args){
	JFrame f=new JFrame("Hello World!");
	f.setVisible(true);
   }

}
