package builder.elements;

import factory.variables.*;
import factory.methods.*;
//import factory.*;
import java.util.*;

public class Method_Area {
	LinkedList<Variable> atributes;
//	LinkedList<Klasa> klasy;
	Map<String,Klasa> klasy;
//	LinkedList<IntVariable> atributesInt;
//	LinkedList<CharVariable> atributesChar;
//	LinkedList<DoubleVariable> atributesDouble;
	LinkedList<Method> methods;
	
	public Method_Area(){
		atributes = new LinkedList<Variable>();
		klasy = new HashMap<String,Klasa>();
//		atributesInt = new LinkedList<IntVariable>();
//		atributesChar = new LinkedList<CharVariable>();
//		atributesDouble = new LinkedList<DoubleVariable>();
		methods = new LinkedList<Method>();
	}
	
	void addAtr(Variable z){
		atributes.add(z);
	}
/*	
	void addAtr(CharVariable z){
		atributesChar.add(z);
	}
	
	void addAtr(IntVariable z){
		atributesInt.add(z);
	}
	
	void addAtr(DoubleVariable z){
		atributesDouble.add(z);
	}
*/	
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
			System.out.println(atributes.get(i).name+" "+ atributes.get(i).getValue());// + atributes.get(i).value);
				//(IntVariable) a = new IntVariable(atributes.get(i));
			}
/*		
		for(int i = 0; i < atributesInt.size(); i++){
			System.out.println(atributesInt.get(i).name + " " + atributesInt.get(i).getValue());
		
		}
		
		for(int i = 0; i < atributesChar.size(); i++){
			System.out.println(atributesChar.get(i).name + " " + atributesChar.get(i).getValue());
		
		}
		
		for(int i = 0; i < atributesDouble.size(); i++){
			System.out.println(atributesDouble.get(i).name + " " + atributesDouble.get(i).getValue());
		
		}
*/		
		for(int i = 0; i < methods.size(); i++){
			System.out.println(methods.get(i).name);
		
		}
		
	}
}

