package name.czernohous.zock_2016;
import java.util.*;
public class MovablePanel extends SizedPanel {

	
 List<GameObject> gos = new ArrayList<GameObject>();

public void paintComponent(java.awt.Graphics g) {
	super.paintComponent(g);
	for (GameObject go:gos) go.paintTo(g);
}
	
public void move() {for (GameObject go:gos) go.move();}
	
public void doOnTick() {
		move () ;
		repaint () ;
		
		}
}
