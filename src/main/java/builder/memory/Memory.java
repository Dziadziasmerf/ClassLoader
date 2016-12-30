package memory;

import elements.*;
import factory.*;

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
	
	void print(){
		System.out.println("Sterta: "+heap.makeString());
		System.out.println("Sterta: "+stos.makeString());
	}
}
