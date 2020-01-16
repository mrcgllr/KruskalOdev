import java.util.ArrayList;

public class Heap {
	
	ArrayList<Vertex> array;

	public Heap(){
		array = new ArrayList<Vertex>();
		array.add(null);
	}
	
	public void ekle(Vertex vertex){
		array.add(vertex);
		if (array.size() > 2)
			yukaridanAsagiyaEkle(array.size()-1);
	}

	public void yukaridanAsagiyaEkle(int index) {
		int anne;
		Vertex gecici;

		while(true){
			anne = index / 2;
			if(anne > 0 && array.get(anne).getOncelik() > array.get(index).getOncelik()){
				gecici  = array.get(anne);
				array.set(anne, array.get(index));
				array.set(index, gecici);
				index = anne;
			}
			else 
				return;			 
		}
		
	}
	public void heapify(){
		array.set(1, array.get(array.size() - 1));
		array.remove(array.size() - 1);
		int anne = 1;
		int solCocuk, sagCocuk, minIndex;
		Vertex gecici;

		while(true){
			solCocuk = anne * 2;
			sagCocuk = anne * 2 + 1;
			minIndex = anne;
			if(array.size() > solCocuk && array.get(minIndex).getOncelik() > array.get(solCocuk).getOncelik())
				minIndex = solCocuk;
			if(array.size() > sagCocuk && array.get(minIndex).getOncelik() > array.get(sagCocuk).getOncelik())
				minIndex = sagCocuk;

			if (anne != minIndex){
				gecici  = array.get(anne);
				array.set(anne, array.get(minIndex));
				array.set(minIndex, gecici);
				anne = minIndex;
			}
			else 
				return;			 
		}
	}
	
	
	public Vertex kokDondur(){
		Vertex kok = array.get(1);
		heapify();
		return kok;

	}
	
	
	public void oncelikDegerDegistir(Vertex v, double deger){
		v.setOncelik(deger);
		int index = array.indexOf(v);
		array.set(index, v);
		yukaridanAsagiyaEkle(index);
	}
	
	public boolean isEmpty(){
		if(array.size() == 1)
			return true;
		return false;
	}
	
	public boolean contains(Vertex v){
		if(array.indexOf(v) == -1)
			return false;
		return true;
	}

}
