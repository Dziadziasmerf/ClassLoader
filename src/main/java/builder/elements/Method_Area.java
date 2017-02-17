package builder.elements;

import factory.variables.*;
import factory.methods.*;
//import factory.*;
import java.util.*;

public class Method_Area {
	LinkedList<Variable> atributes;
//	LinkedList<IntVariable> atributesInt;
//	LinkedList<CharVariable> atributesChar;
//	LinkedList<DoubleVariable> atributesDouble;
	LinkedList<Method> methods;
	
	public Method_Area(){
		atributes = new LinkedList<Variable>();
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
	
	void callMethod(){
		
	}
	
	public void print(){
		for(int i = 0; i < atributes.size(); i++){
			System.out.println(atributes.get(i).name);// + atributes.get(i).value);
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

