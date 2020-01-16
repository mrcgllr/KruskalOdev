public class Vertex {	
	private int id;
	private double x, y, oncelik;
	
	public Vertex(int id, double x, double y){
		this.id = id;
		this.x = x;
		this.y = y;
		oncelik = Double.POSITIVE_INFINITY;
	}
	@Override
	public boolean equals(Object obj){
		if(obj == null) 
			return false;
		if (this.getClass() == obj.getClass()){
			Vertex vertex = (Vertex) obj;
			if (vertex.getId() == this.getId())
				return true;
		}
		return false;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getOncelik() {
		return oncelik;
	}

	public void setOncelik(double oncelik) {
		this.oncelik = oncelik;
	}

	

}
