package building;

import elements.*;
import factory.*;
import memory.Memory;

public class Builder {
	Klasa klasa;
	Factory factory;
	
	Builder(Factory f){
		klasa = null;
		factory = f;
	};
	
	void buildClass(){
		if(klasa != null) klasa = null;
		klasa = new Klasa();
	}
	
	void buildName(String s){
		klasa.setName(s);
	}
	
	void buildAtribute(String name, VariableType type){
		klasa.addAtr(factory.createVariable(name,type));
	}

	void buildMethod(String name){
		klasa.addMth(factory.createMethod(name));
	}
	
	void toMemory(Memory m){
		m.addClass(klasa);
		klasa = null;
	}
	
	void printClass(){
		System.out.println("Klasa w builderze: ");
		System.out.println("Nazwa: " + klasa.name);
	}
}
