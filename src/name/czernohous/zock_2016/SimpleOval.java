
package name.czernohous.zock_2016;
import java.awt.Color;
public class SimpleOval extends GeometricObject {

	public SimpleOval(double w, double h, Vertex pos, Color color){
		super(w,h,pos,color);
	}
	
	public SimpleOval(double w, double h, double x, double y, Color color){
		super(w,h,new Vertex(x,y),color);
	}
	
	public SimpleOval(double w, double h, double x, double y){
		super(w,h,new Vertex(x,y),new Color(0,0,0));
	}
	@Override public double area(){return Math.PI*width*height/4;}

	public @Override String toString(){
		return "SimpleOval("+super.toString()+")";
	}
	
	public @Override boolean equals(Object that){
		return (that instanceof SimpleOval) && super.equals(that);
	}
}
