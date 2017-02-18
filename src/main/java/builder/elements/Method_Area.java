package builder.elements;

import factory.variables.*;
import factory.methods.*;
//import factory.*;
import java.util.*;

public class Method_Area {
	LinkedList<Variable> atributes;
	Map<String,Klasa> klasy;
	LinkedList<Method> methods;
	
	public Method_Area(){
		atributes = new LinkedList<Variable>();
		klasy = new HashMap<String,Klasa>();
		methods = new LinkedList<Method>();
	}
	
	void addAtr(Variable z){
		atributes.add(z);
	}
	void addMth(Method m){
		methods.add(m);
	}
	
	void addKlasa(Klasa k, String name){
		klasy.put(name,k);
	}
	
	Method callMethod(String name){
		for(int i = 0; i < methods.size(); i++){
			if(methods.get(i).name.equals(name)) return methods.get(i);
		}
		return null;
		
	}
	
	public void print(){
		for(int i = 0; i < atributes.size(); i++){
			System.out.println(atributes.get(i).name+" "+ atributes.get(i).getValue());
			}
		for(int i = 0; i < methods.size(); i++){
			System.out.println(methods.get(i).name);
		
		}
		
	}
}

