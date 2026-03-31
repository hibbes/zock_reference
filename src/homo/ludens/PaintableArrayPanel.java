package homo.ludens;

public class PaintableArrayPanel extends SizedPanel{
	
	Paintable[] ps;
	
	public PaintableArrayPanel(Paintable[] pa){ps=pa;}
	
	public void paintComponent(java.awt.Graphics g){
		for(Paintable p:ps) p.paintTo(g);
	}

}
