import java.util.ArrayList;
import java.util.HashMap;
public class Kruskal {
	
	ArrayList<Vertex> vertex;
	
	public Kruskal(){
		vertex = new ArrayList<Vertex>();
	}
	
	public ArrayList<Edge> getMST(Graph graph,Vertex c){
		HashMap <Vertex, Double> keys = new HashMap<Vertex, Double>();
		HashMap <Vertex, Edge> parents = new HashMap <Vertex, Edge>();
		ArrayList<Edge> mst = new ArrayList<Edge>();
		Heap heap = new Heap();
		int x;
		int y;
		for(Vertex v : graph.getVertexList()){
			keys.put(v, Double.POSITIVE_INFINITY);
			parents.put(v, null);
			heap.ekle(v);
		}
		keys.put(c,0.0);
		heap.oncelikDegerDegistir(c, 0);
		
		while(!heap.isEmpty()) {
			Vertex min = heap.kokDondur();
			for(Edge e : graph.getAdjacents(min)){
				x = e.getBaslangicDegeri().getId();
				y = e.getBitisDegeri().getId();
				
				if(x!=y) {
					mst.add(e);
				}
			}
		}
		
		return mst;
	}
	
}
