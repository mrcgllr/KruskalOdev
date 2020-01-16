public class Edge implements Comparable<Edge>{
	private Vertex baslangicDegeri;
	private Vertex bitisDegeri;
	private double uzaklik;
	private boolean labeled = false;
	
	public Edge(Vertex baslangicDegeri, Vertex bitisDegeri, double uzaklik) {
		this.baslangicDegeri = baslangicDegeri;
		this.bitisDegeri = bitisDegeri;
		this.uzaklik = uzaklik;
	}

	public Vertex getBaslangicDegeri() {
		return baslangicDegeri;
	}

	public void setBaslangicDegeri(Vertex baslangicDegeri) {
		this.baslangicDegeri = baslangicDegeri;
	}

	public Vertex getBitisDegeri() {
		return bitisDegeri;
	}

	public void setBitisDegeri(Vertex bitisDegeri) {
		this.bitisDegeri = bitisDegeri;
	}

	public double getUzaklik() {
		return uzaklik;
	}

	public void setUzaklik(double uzaklik) {
		this.uzaklik = uzaklik;
	}

	public boolean isLabeled() {
		return labeled;
	}

	public void setLabeled(boolean labeled) {
		this.labeled = labeled;
	}

	@Override
	public int compareTo(Edge edge) {
		if(this.getUzaklik() < edge.getUzaklik())
			return -1;
		if(this.getUzaklik() > edge.getUzaklik())
			return 1;
		return 0;
		
	}
	
	

}
