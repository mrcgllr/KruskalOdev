import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;

public class Clustering {
	private HashMap <Integer, ArrayList<Vertex>> clusters;
	private ArrayList<Edge> mst;
	private Color COLORS[] = {Color.RED, Color.BLUE, Color.PINK, Color.BLACK, Color.YELLOW, Color.GREEN, Color.ORANGE};
	public Clustering(ArrayList<Edge> mst){
		this.mst = mst;
		clusters = new HashMap <Integer, ArrayList<Vertex>>();
	}
	
	public void grupla(ArrayList<Vertex> initials){
		for(int i = 0; i < initials.size(); i++){
			Vertex initial = initials.get(i);
			clusters.put(i, new ArrayList<Vertex>());
			grupOlustur(initial, i);
		}
	}
	public void grupOlustur(Vertex v, int cluster){
		clusters.get(cluster).add(v);
		for( int i = 0; i < mst.size(); i++ ){
			if(! mst.get(i).isLabeled()){
				if(v.equals(mst.get(i).getBaslangicDegeri())){
					mst.get(i).setLabeled(true);
					grupOlustur(mst.get(i).getBaslangicDegeri(), cluster);
				}
				else if(v.equals(mst.get(i).getBaslangicDegeri())){
					mst.get(i).setLabeled(true);
					grupOlustur(mst.get(i).getBaslangicDegeri(), cluster);
				}
			}
		}
	}
	
	public ArrayList<JLabel> noktaRenklendir(ArrayList<Vertex> vertex) {
		ArrayList<JLabel> jl=new ArrayList();	
		
		for(int i =0;i<vertex.size();i++) {
			vertex=clusters.get(i);
			for(int j=0;j<vertex.size();j++) {
				double x = vertex.get(j).getX();
				double y = vertex.get(j).getY();
				jl.add(new JLabel("."));
				jl.get(i).setBounds((int)x, (int)y, 50,50);
				jl.get(i).setFont(new Font("Tahoma",Font.BOLD,30));
				jl.get(i).setBackground(COLORS[i]);
				jl.get(i).setForeground(COLORS[i]);
			}
		
		}
		
		return jl;
	}

}
