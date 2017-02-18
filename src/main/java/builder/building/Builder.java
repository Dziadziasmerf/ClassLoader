package builder.building;

import builder.elements.*;
import factory.*;
import factory.variables.*;
import factory.methods.*;
import builder.memory.Memory;
import java.util.*;

public class Builder {
	Klasa klasa;
	Factory factory;
	
	public Builder(Factory f){
		klasa = null;
		factory = f;
	};
	
	public boolean checkClassLoader(String name, Memory m){
		if (m.find(name) != null) return true;
		
		Class<?> c = null;
		try{
		c = ClassLoader.getSystemClassLoader().loadClass(name);
		}catch(ClassNotFoundException e){
			return false;
		}
		if (c == null) return false;
		return true;
	}
	
	public void buildClass(){
		if(klasa != null) klasa = null;
		klasa = new Klasa();
	}
	
	public void buildName(String s){
		klasa.setName(s);
	}
	
	public void buildAtribute(String name, VariableType type){
		klasa.addAtr((Variable) factory.createVariable(name,type));
	}
	public void buildAtribute(String name, VariableType type, Object value){
		Variable v = (Variable) factory.createVariable(name,type);
		v.setValue(value);
		klasa.addAtr(v);
	};
	
	public Variable buildAtributeOut(String name, VariableType type, Object value){
			Variable v = (Variable) factory.createVariable(name,type);
			v.setValue(value);
			return v;
		};
	
	public void buildMethod(String name, LinkedList<String> bytecode){
		klasa.addMth(factory.createMethod(name, bytecode));
	}
	
	public Klasa getKlasa(){
		return this.klasa;
	}
	
	public void addClass(Klasa k, String name){
		klasa.addKlasa(k, name);
	}
	
	public void deleteKlasa(){
		this.klasa = null;
	}
	
	public void toMemory(Memory m){
		m.addClass(klasa);
		klasa = null;
	}
	
	public void printClass(){
		System.out.println("Klasa w builderze: ");
		System.out.println("Nazwa: " + klasa.name);
		klasa.print();
	}
}
