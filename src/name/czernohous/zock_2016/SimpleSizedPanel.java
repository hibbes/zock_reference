package name.czernohous.zock_2016;
import javax.swing.*;
import name.czernohous.zock_2016.ShowInFrame;

public class SimpleSizedPanel extends SizedPanel {
	public void paintComponent(java.awt.Graphics g){
		g.fillRect(30, 50, 45, 80);
	}

	public static void main(String[] args) {
		ShowInFrame.show(new SimpleSizedPanel());
	}

}
