package elements;

import java.util.*;

public class Method_Area {
	LinkedList<Variable> atributes;
	LinkedList<Method> methods;
	
	void addAtr(Zmienna z){
		atributes.add(z);
	}
	
	void addMth(Method m){
		methods.add(m);
	}
}
