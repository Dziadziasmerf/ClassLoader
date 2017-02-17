package builder.memory;

import builder.elements.Klasa;
import java.util.*;

public class Heap {
	public LinkedList<Klasa> klasy;
	
	public Heap(){
		klasy = new LinkedList<Klasa>();
	}
	
	public void push(Klasa k){
		klasy.add(k);
	}
	
	public void clear(){
		klasy.clear();
	}
	
	public String makeString(){
		return klasy.toString();
	}
	
	public void print(){
		for(int i = 0; i < klasy.size(); i++){
			klasy.get(i).print();
		}
		
	}
}
