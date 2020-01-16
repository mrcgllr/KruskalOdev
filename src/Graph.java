import java.util.ArrayList;
import java.util.HashMap;
public class Graph {
	
	private HashMap<Vertex, ArrayList<Edge>> komsu;
	private ArrayList<Vertex> kenar;

	public Graph() {
		komsu = new HashMap<Vertex, ArrayList<Edge>>();
		kenar = new ArrayList<Vertex>();
	}
	
	//vertex oluþtur
	void vertexEkle(int id, double x, double y){
		Vertex node = new Vertex(id, x, y);
		komsu.put(node, new ArrayList<Edge>());
		kenar.add(node);
	}
	
	public void edgeEkle(Vertex a, Vertex b){
		double uzaklik = oklidUzakligi(a, b);
		komsu.get(a).add(new Edge(a,b,uzaklik));
		komsu.get(b).add(new Edge(b, a,uzaklik));
	}

	public double oklidUzakligi(Vertex a, Vertex b) {
		return Math.sqrt(Math.pow((a.getX() - b.getX()), 2) + Math.pow((a.getY() - b.getY()), 2));
	}
	
	public ArrayList<Vertex> getVertexList(){
		return kenar;
	}
	
	 void generateEdges(){
		for(int i = 0; i < kenar.size(); i++){
			for(int j = i+1; j < kenar.size(); j++){
				edgeEkle(kenar.get(i),kenar.get(j));
			}
		}
	}
	public Vertex getRandomVertex(){
		return kenar.get(0);
	}

	public Vertex getVertexById(int i){
		return kenar.get(i);
	}

	public ArrayList<Edge> getAdjacents(Vertex v){
		return komsu.get(v);
	}
	
	public ArrayList<Edge> getEdgeList(){
		ArrayList<Edge> tmp = new ArrayList<Edge>();
		for(int i = 0; i < kenar.size(); i++){
			tmp.addAll(komsu.get(kenar.get(i)));
		}
		return tmp;
	}
	
	


}
