package name.czernohous.zock_2016;
public class TestVertex {

	public static void main(String[] args) {
		   Vertex v1 = new Vertex(42,53);
		   Vertex v2 = new Vertex(42,53);
		  /* Vertex v2 = new Vertex(32,4);
		   System.out.println(v1.distance(v2));
		   v2.normalize();
		   System.out.println(v2.toString());
		   System.out.println(v1.length()); */
		
		System.out.println(v1);
		Vertex v3 = v1.add(v1);
		v1.skalarMultMod(4);
		System.out.println(v1);
		
		   
	}	   
	
}
