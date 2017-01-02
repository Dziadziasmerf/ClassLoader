package memory;

import elements.Klasa;
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
	
}