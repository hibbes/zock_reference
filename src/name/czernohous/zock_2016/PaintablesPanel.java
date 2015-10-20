package name.czernohous.zock_2016;
import name.czernohous.zock_2016.util.ShowInFrame;
import java.util.*;

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
