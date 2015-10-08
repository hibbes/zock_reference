package name.czernohous.zock_2016;

public class SimpleRectangle extends GeometricObject {
	



	public SimpleRectangle(double w, double h, Vertex pos){
		super(w,h,pos);
	}
	
	public SimpleRectangle(double w, double h){
		super(w,h,new Vertex(0,0));
	}
	
	public @Override String toString(){
		return "SimpleRectangle("+super.toString()+")";
	}
	
	public @Override boolean equals(Object that){
		return (that instanceof SimpleRectangle) && super.equals(that);
	}
}
