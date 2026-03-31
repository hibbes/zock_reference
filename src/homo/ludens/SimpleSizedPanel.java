package homo.ludens;
import javax.swing.*;
import homo.ludens.util.ShowInFrame;

public class SimpleSizedPanel extends SizedPanel {
	public void paintComponent(java.awt.Graphics g){
		g.fillRect(30, 50, 45, 80);
	}

	public static void main(String[] args) {
		ShowInFrame.show(new SimpleSizedPanel());
	}

}
