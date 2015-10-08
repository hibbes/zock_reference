package name.czernohous.zock_2016;
import java.awt.Color;

import name.czernohous.zock_2016.ShowInFrame;
import java.awt.Color;

public class PaintablePanel extends SizedPanel{

	Paintable pa;
	public PaintablePanel(Paintable pa){this.pa=pa;}
	
	public void paintComponent(java.awt.Graphics g){
		pa.paintTo(g);
	}
		public static void main(String [] args){
			ShowInFrame.show (new PaintablePanel(new PaintableOval(100,50,30,50,new Color(23,23,23))));
			ShowInFrame.show (new PaintablePanel(new PaintableOval(10,10,130,40,new Color(59,34,65))));
		}
	}
	

