package name.czernohous.zock_2016;
import javax.swing.*;
import java.awt.Dimension;
import name.czernohous.zock_2016.ShowInFrame;

public class SizedPanel extends JPanel {

	int preferredWidth=400;
	int preferredHeight=400;


	public static void main(String[] args) {
		ShowInFrame.show(new SizedPanel());
	}
	
	public SizedPanel(int w, int h){
		preferredWidth=w;
		preferredHeight=h;
	}

	public SizedPanel(){}
	
	@Override public Dimension getPreferredSize(){
		return new Dimension(preferredWidth,preferredHeight);
	}
}
