package name.czernohous.zock_2016;

import name.czernohous.zock_2016.util.ShowInFrame;
import javax.swing.JPanel;

	public class PaintableImage extends JPanel implements Paintable{
		MyImage mi;
		
		public PaintableImage(MyImage mi){this.mi=mi;}
		public PaintableImage(String name){this.mi=new MyImage(name);}
		
		public void paintTo(java.awt.Graphics g){
			g.drawImage(mi.get(),0,0,this);
		}
		
		public static void main(String[]args){
			PaintableImage pi= new PaintableImage("test.png"); // Direkt ins bin-Verzeichnis
			System.out.println(pi.mi.get().getHeight(pi));
			ShowInFrame.show(new PaintablePanel(pi));
		}

}
