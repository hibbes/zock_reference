package name.czernohous.zock_2016;
import javax.swing.*;

public class FirstPanel extends JPanel {

	    int[] xPoints = {40, 60, 70, 80, 100, 80, 70, 60};
	    int[] yPoints = {440, 430, 410, 430, 450, 470, 450, 460};
	    int nPoints = xPoints.length;
	
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