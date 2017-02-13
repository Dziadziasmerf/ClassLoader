package builder.memory;

import builder.elements.*;
//import factory.*;
import factory.methods.Frame;

public class Memory {
	private Heap heap;
	private Stos stos;
	
	public Memory(){
		heap = new Heap();
		stos = new Stos();
	}
	
	public void addClass(Klasa k){
		heap.push(k);
	}
	
	public void onStack(Frame r){
		stos.push(r);
	}
	
	void offStack(){
		stos.pop();
	}
	
	void clearHeap(){
		heap.clear();
	}

	void clearStack(){
		stos.clear();
	}
	
	void clearAll(){
		heap.clear();
		stos.clear();
	}
	
	public Klasa find(String name){	
		for(int i = 0; i < heap.klasy.size(); i++){
			if(heap.klasy.get(i).name == name) return heap.klasy.get(i); 
		}
		
		return null;
	}
	
	void print(){
		System.out.println("Sterta: "+heap.makeString());
		System.out.println("Sterta: "+stos.makeString());
	}
}
