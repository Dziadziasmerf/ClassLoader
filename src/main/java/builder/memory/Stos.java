package builder.memory;

import factory.variables.*;
import java.util.*;

public class Stos {
	public Stack<Variable> stos;
	
	public Stos(){
		stos = new Stack<Variable>();
	}
	
	public void push(Variable f){
		if(f != null) stos.push(f);
	}
	
	public Variable pop(){
		if(this.stos.isEmpty() == false )return stos.pop();
		return null;
	}
	
	public void clear(){
		stos.clear();
	}
	
	public boolean isEmpty(){
		if(stos.isEmpty() == true) return true;	
		return false;		
	}
	
	public void print(){
		Stack<Variable> s = this.stos;
		Variable v = null;
		System.out.println("Stos: ");
		while(s.isEmpty() == false){System.out.println(s.pop().getValue());
		}
	}
	
	public String makeString(){
		return stos.toString();
	}
	
}
