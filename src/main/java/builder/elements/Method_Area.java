package elements;

import factory.variables.*;
import factory.methods.*;
//import factory.*;
import java.util.*;

public class Method_Area {
	LinkedList<Variable> atributes;
	LinkedList<Method> methods;
	
	public Method_Area(){
		atributes = new LinkedList<Variable>();
		methods = new LinkedList<Method>();
	}
	
	void addAtr(Variable z){
		atributes.add(z);
	}
	
	void addMth(Method m){
		methods.add(m);
	}
}
