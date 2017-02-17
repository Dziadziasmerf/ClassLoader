package builder.memory;

import factory.methods.Frame;

//import java.awt.Frame;
import java.util.*;

public class Stos {
	public Stack<Frame> stos;
	
	public Stos(){
		stos = new Stack<Frame>();
	}
	
	public void push(Frame f){
		stos.push(f);
	}
	
	public Frame pop(){
		return stos.pop();
	}
	
	public void clear(){
		stos.clear();
	}
	
	public String makeString(){
		return stos.toString();
	}
	
}
