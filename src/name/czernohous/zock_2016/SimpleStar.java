package name.czernohous.zock_2016;
import java.awt.Color;
public class SimpleStar extends GeometricObject {

	// Create a polygon
    int[] xPoints = {(int)pos.x, (int)pos.x+20, (int)pos.x+30, (int)pos.x+40, (int)pos.x+60, (int)pos.x+40, (int)pos.x+30, (int)pos.x+20};
    int[] yPoints = {(int)pos.y, (int)pos.y-10, (int)pos.y-30, (int)pos.y-10, (int)pos.y, (int)pos.y+10, (int)pos.y+30, (int)pos.y+10};
    int nPoints = xPoints.length;
   
	
	
	
	public SimpleStar(int[] xPoints, int[] yPoints, int nPoints, Color color){
		this.xPoints=xPoints;
		this.yPoints=yPoints;
		this.nPoints=nPoints;
		this.color=color;
		
	}
/*
 *  Das könnte kompliziert werden!	
	public @Override String toString(){
		return "SimpleOval("+super.toString()+")";
	}
	

 * 
 * 	public @Override boolean equals(Object that){
 
	
		return (that instanceof SimpleOval) && super.equals(that);
	}*/
}
