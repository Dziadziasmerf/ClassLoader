package builder.building;

import builder.elements.*;
import factory.*;
import factory.variables.*;
import factory.methods.*;
import builder.memory.Memory;

public class Builder {
	Klasa klasa;
	Factory factory;
	
	public Builder(Factory f){
		klasa = null;
		factory = f;
	};
	
	public void buildClass(){
		if(klasa != null) klasa = null;
		klasa = new Klasa();
	}
	
	public void buildName(String s){
		klasa.setName(s);
	}
	
	public void buildAtribute(String name, VariableType type){
		klasa.addAtr(factory.createVariable(name,type));
	}

	public void buildAtribute(String name, VariableType type, int value){
		IntVariable v = (IntVariable) factory.createVariable(name,type);
		v.setValue(value);
		klasa.addAtr(v);
	};
	
	public void buildAtribute(String name, VariableType type, char value){
		CharVariable v = (CharVariable) factory.createVariable(name,type);
		v.setValue(value);
		klasa.addAtr(v);
	};
	
	public void buildAtribute(String name, VariableType type, double value){
		DoubleVariable v = (DoubleVariable) factory.createVariable(name,type);
		v.setValue(value);
		klasa.addAtr(v);
	};

// do odkomentowania po zmianach w Variable
//
//	public void buildAtribute(String name, VariableType type, Object value){
//		Variable v = factory.createVariable(name,type);
//		v.setValue(value);
//		klasa.addAtr(v);
//	};
	
	public void buildMethod(String name){
		klasa.addMth(factory.createMethod(name));
	}
	
	public void toMemory(Memory m){
		m.addClass(klasa);
		klasa = null;
	}
	
	public void printClass(){
		System.out.println("Klasa w builderze: ");
		System.out.println("Nazwa: " + klasa.name);
	}
}
