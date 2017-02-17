package builder.memory;

import factory.variables.*;
//import java.awt.Frame;
import java.util.*;

public class Stos {
	public Stack<Variable> stos;
	
	public Stos(){
		stos = new Stack<Variable>();
	}
	
	public void push(Variable f){
		stos.push(f);
	}
	
	public Variable pop(){
		return stos.pop();
	}
	
	public void clear(){
		stos.clear();
	}
	
	public boolean isEmpty(){
		if(stos.isEmpty() == true) return true;	
		return false;		
	}
	
	public String makeString(){
		return stos.toString();
	}
	
}
